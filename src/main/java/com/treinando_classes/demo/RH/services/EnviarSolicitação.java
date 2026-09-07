package com.treinando_classes.demo.RH.services;
import com.treinando_classes.demo.RH.regras_Enums.RegrasDeEnums;
import com.treinando_classes.demo.RH.repositories.SolicitacoesRepository;
import com.treinando_classes.demo.RH.Domain.ControlleStatus;
import com.treinando_classes.demo.RH.repositories.TipoDeSolicitacaoRepository;
import com.treinando_classes.demo.RH.models.TipodeSolicitacao;

import java.time.LocalDate;



public class EnviarSolicitação {
    private final TipoDeSolicitacaoRepository repository;

    public EnviarSolicitação(TipoDeSolicitacaoRepository repository, TipodeSolicitacao nova_solicitacao) {
        this.repository = repository;
    }

    public TipodeSolicitacao RegistrarSolicitação(RegrasDeEnums.MeioDeAfastamento tipo, String descriçao, LocalDate data_emissao) {

        TipodeSolicitacao nova_solicitacao = TipodeSolicitacao.builder()
                .tipo(tipo)
                .descricao(descriçao)
                .data_emissao(data_emissao)
                .build();

        return nova_solicitacao;
    }
}

