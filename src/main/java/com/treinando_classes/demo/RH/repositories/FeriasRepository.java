package com.treinando_classes.demo.RH.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import com.treinando_classes.demo.RH.FeriasAtestadosAfastamentos.models.Ferias;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.parameters.P;

import java.util.List;

public interface FeriasRepository extends JpaRepository<Ferias, Long>{
    @Query("select Fe from Ferias Fe where Fe.solicitacao_id.id_funcionario = :id_funcionario")
    List<Ferias>ListarFeriasPorFuncionarios(@Param("id_funcionario")long id_funcionario);
}
