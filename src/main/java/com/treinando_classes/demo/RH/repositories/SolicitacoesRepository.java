package com.treinando_classes.demo.RH.repositories;

import com.treinando_classes.demo.RH.models.Solicitacoes;
import com.treinando_classes.demo.RH.regras_Enums.RegrasDeEnums;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.Optional;

public interface SolicitacoesRepository extends JpaRepository<Solicitacoes, Long> {

    Optional<Solicitacoes> findFirstByIdFuncionarioAndStatusAndDataInicioLessThanEqualAndDataFimGreaterThanEqual(
            Long idFuncionario,
            RegrasDeEnums.status status,
            LocalDate dataFim,
            LocalDate dataInicio
    );
}