package com.treinando_classes.demo.RH.services;

import com.treinando_classes.demo.RH.models.Solicitacoes;
import com.treinando_classes.demo.RH.Domain.EstadoSolicitacao;
import com.treinando_classes.demo.RH.regras_Enums.RegrasDeEnums;
import com.treinando_classes.demo.RH.repositories.SolicitacoesRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class Ferias {

    private final SolicitacoesRepository solicitacoesRepository;

    public Ferias(SolicitacoesRepository solicitacoesRepository) {
        this.solicitacoesRepository = solicitacoesRepository;
    }

    public void Validar(LocalDate dataInicio, LocalDate dataFim, int periodo_tirado, Long idFuncionario) {

        RegrasDeEnums.status resultado = EstadoSolicitacao.ferias(dataInicio, dataFim, periodo_tirado);

        if (resultado != RegrasDeEnums.status.PENDENTE) {
            throw new IllegalArgumentException("regra de Status violada" + resultado);
        }

        Optional<Solicitacoes> ferias_existentes = solicitacoesRepository
                .findFirstByIdFuncionarioAndStatusAndDataInicioLessThanEqualAndDataFimGreaterThanEqual(
                        idFuncionario,
                        RegrasDeEnums.status.APROVADO,
                        dataFim,
                        dataInicio
                );

        if (ferias_existentes.isPresent()) {
            throw new IllegalArgumentException("já existe uma solicitação de férias aprovada nesse período");
        }
    }
}