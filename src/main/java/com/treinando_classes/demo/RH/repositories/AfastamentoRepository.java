package com.treinando_classes.demo.RH.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import com.treinando_classes.demo.RH.FeriasAtestadosAfastamentos.models.Afastamento;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface AfastamentoRepository extends JpaRepository<Afastamento, Long> {

    @Query("select Af from Afastamento Af where Af.solicitacao_id.id_funcionario.id = :id_funcionario")
    List<Afastamento>ListarAfastamentosPorFuncionario(@Param("id_funcionario")long id_funcionario);
}
