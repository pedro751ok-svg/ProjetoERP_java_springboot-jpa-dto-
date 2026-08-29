package com.treinando_classes.demo.RH.services;
import com.treinando_classes.demo.RH.Domain.EstadoSolicitacao;
import com.treinando_classes.demo.RH.models.Solicitacoes;
import  com.treinando_classes.demo.RH.regras_Enums.RegrasDeEnums;
import com.treinando_classes.demo.RH.repositories.SolicitacoesRepository;
import java.time.LocalDate;
import java.util.Optional;

import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Service;

@Service
public class AfastamentoValidar {

    private SolicitacoesRepository solicitacoesRepository;
    public AfastamentoValidar(SolicitacoesRepository  solicitacoesrepository){
        this.solicitacoesRepository = solicitacoesrepository;
    }
    public void validar(LocalDate data_incio , LocalDate data_fim, long IdFuncionario){
        RegrasDeEnums.status resultado = EstadoSolicitacao.Afastamentos(data_incio,data_fim);
        if(resultado != RegrasDeEnums.status.PENDENTE){
            throw new IllegalArgumentException("regra de status violada" + resultado);
        }
        Optional<Solicitacoes> afastamentos_exixstentes = solicitacoesRepository
                .findFirstByIdFuncionarioAndStatusAndDataInicioLessThanEqualAndDataFimGreaterThanEqual(
                        IdFuncionario,
                        RegrasDeEnums.status.APROVADO,
                        data_incio,
                        data_fim


        );
        if(afastamentos_exixstentes.isPresent()){
            throw new IllegalArgumentException("funcionario ja pussui uma afastamento ");
        }
    }
}
