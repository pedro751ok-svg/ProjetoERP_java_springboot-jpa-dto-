package com.treinando_classes.demo.RH.repositories;

import com.treinando_classes.demo.RH.FeriasAtestadosAfastamentos.models.TipodeSolicitacao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TipoDeSolicitacaoRepository
        extends JpaRepository<TipodeSolicitacao, Long> {

    Optional<TipodeSolicitacao> findFirstByTipoAndId(String tipo, long id);
}