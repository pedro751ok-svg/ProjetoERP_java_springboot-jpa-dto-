package com.treinando_classes.demo.RH.repositories;

import com.treinando_classes.demo.RH.FeriasAtestadosAfastamentos.models.Solicitacoes;
import com.treinando_classes.demo.RH.regras_Enums.RegrasDeEnums;
import com.treinando_classes.demo.Shared.Funcionario;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface SolicitacoesRepository extends JpaRepository<Solicitacoes, Long> {
    boolean existsById(long id);
    List<Solicitacoes> findByFuncionarioId (Long funcionarioId);

    Optional<Solicitacoes> findFirstByFuncionario_IdAndTipo_IdAndStatusAndDataInicioAndDataFim(
            Long IdFuncionario,
            Long id_tipo,
            RegrasDeEnums.status status,
            LocalDate DataInicio,
            LocalDate DataFim

    );
}