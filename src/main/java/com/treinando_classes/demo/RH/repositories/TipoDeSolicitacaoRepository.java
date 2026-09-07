package com.treinando_classes.demo.RH.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import com.treinando_classes.demo.RH.models.TipodeSolicitacao;

import java.util.Optional;

public interface TipoDeSolicitacaoRepository {
    public interface TipoSolicitacaoRepository extends JpaRepository<TipodeSolicitacao, Long>{
        boolean existsById(long Id);

        Optional<TipodeSolicitacao> findFirstByTipoAndId(String tipo,long id);
    }
}
