package com.treinando_classes.demo.RH.services;
import com.treinando_classes.demo.RH.models.Solicitacoes;
import com.treinando_classes.demo.RH.models.TipodeSolicitacao;
import com.treinando_classes.demo.RH.regras_Enums.RegrasDeEnums;
import com.treinando_classes.demo.RH.repositories.SolicitacoesRepository;
import com.treinando_classes.demo.Shared.Funcionario;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;
import java.util.Optional;

public class GerenciadorDeSolicitacoes {
    private final SolicitacoesRepository repository;
    public GerenciadorDeSolicitacoes(SolicitacoesRepository repository){
        this.repository = repository;
    }
    public Solicitacoes gerenciador(long id_funcionario, long id_tipo , RegrasDeEnums.status status, LocalDate DataInicio, LocalDate DataFim) {

        Optional<Solicitacoes> solicitacao_inexistente = repository.
                findFirstById_funcionario_IdAndId_tipo_IdAndStatusAndDataInicioAndDataFim(
                        id_funcionario,
                        id_tipo,
                        status,
                        DataInicio,
                        DataFim

                );

        if(status != RegrasDeEnums.status.PENDENTE){
            throw new  IllegalArgumentException("erro de status, solicitacao deve ester pendente");
        }
    }
}
