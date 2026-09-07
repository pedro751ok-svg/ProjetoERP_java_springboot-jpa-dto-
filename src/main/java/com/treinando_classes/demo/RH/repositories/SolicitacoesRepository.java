package com.treinando_classes.demo.RH.repositories;

import com.treinando_classes.demo.RH.models.Solicitacoes;
import com.treinando_classes.demo.RH.regras_Enums.RegrasDeEnums;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.Optional;

public interface SolicitacoesRepository extends JpaRepository<Solicitacoes, Long> {
    boolean existsByIDataEmissao(LocalDate data_emissao);
    boolean existsById(long id);
    Optional<Solicitacoes> findFirstById_funcionario_IdAndId_tipo_IdAndStatusAndDataInicioAndDataFim(
            Long id_funcionario,
            Long id_tipo,
            RegrasDeEnums.status status,
            LocalDate DataInicio,
            LocalDate DataFim

    );
}