package com.treinando_classes.demo.RH.services;


import com.treinando_classes.demo.RH.models.Solicitacoes;
import com.treinando_classes.demo.RH.Domain.EstadoSolicitacao;
import com.treinando_classes.demo.RH.regras_Enums.RegrasDeEnums;
import com.treinando_classes.demo.RH.repositories.SolicitacoesRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;
@Service
public class AtestadoValidar {
    private final SolicitacoesRepository solicitacoesRepository;

    public AtestadoValidar(SolicitacoesRepository solicitacoesRepository) {
        this.solicitacoesRepository = solicitacoesRepository;
    }
    public void validar(LocalDate data_inicio , LocalDate data_fim, long idFuncionario){
        RegrasDeEnums.status resultado = EstadoSolicitacao.Atestados(data_inicio, data_fim);

        if(resultado != RegrasDeEnums.status.PENDENTE){
            throw new IllegalArgumentException("regras de status violada" + resultado );
        }
        Optional<Solicitacoes> atestado_existentes = solicitacoesRepository
                .findFirstByIdFuncionarioAndStatusAndDataInicioLessThanEqualAndDataFimGreaterThanEqual(
                        idFuncionario,
                        RegrasDeEnums.status.APROVADO,
                        data_inicio,
                        data_fim
                );
        if(atestado_existentes.isPresent()){
            throw new IllegalArgumentException("funcionario ja entregou esse mesmo atestado");
        }
    }
}

