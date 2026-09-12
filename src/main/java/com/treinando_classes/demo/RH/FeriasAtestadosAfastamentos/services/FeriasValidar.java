package com.treinando_classes.demo.RH.FeriasAtestadosAfastamentos.services;

import com.treinando_classes.demo.RH.FeriasAtestadosAfastamentos.models.Solicitacoes;
import com.treinando_classes.demo.RH.FeriasAtestadosAfastamentos.Domain.EstadoSolicitacao;
import com.treinando_classes.demo.RH.regras_Enums.RegrasDeEnums;
import com.treinando_classes.demo.RH.repositories.SolicitacoesRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class FeriasValidar {

    private final SolicitacoesRepository solicitacoesRepository;

    public FeriasValidar(SolicitacoesRepository solicitacoesRepository) {
        this.solicitacoesRepository = solicitacoesRepository;
    }

    public void Validar(LocalDate dataInicio, LocalDate dataFim, int periodo_tirado, Long idFuncionario, long id_tipo) {

        RegrasDeEnums.status resultado = EstadoSolicitacao.ferias(dataInicio, dataFim, periodo_tirado);

        if (resultado != RegrasDeEnums.status.PENDENTE) {
            throw new IllegalArgumentException("regra de Status violada" + resultado);
        }

        Optional<Solicitacoes> ferias_existentes = solicitacoesRepository
                .findFirstById_funcionario_IdAndId_tipo_IdAndStatusAndDataInicioAndDataFim(
                        idFuncionario,
                        id_tipo,
                        RegrasDeEnums.status.APROVADO,
                        dataInicio,
                        dataFim

                );

        if (ferias_existentes.isPresent()) {
            throw new IllegalArgumentException("já existe uma solicitação de férias aprovada nesse período");
        }
    }
}