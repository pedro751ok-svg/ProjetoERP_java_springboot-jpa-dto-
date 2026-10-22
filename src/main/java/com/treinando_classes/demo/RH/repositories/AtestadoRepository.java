package com.treinando_classes.demo.RH.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import com.treinando_classes.demo.RH.FeriasAtestadosAfastamentos.models.Atestado;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AtestadoRepository extends JpaRepository<Atestado, Long > {

    @Query("select At from AtestadosAt where At.solicitacao_id.id_funcionario = :id_funcionario")
    List<Atestado>ListarAtestadoPorFucionarios(@Param("id_funcionario")long id_funcionario);
}
