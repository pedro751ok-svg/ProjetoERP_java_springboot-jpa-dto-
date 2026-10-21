package com.treinando_classes.demo.RH.ControleDePagamentosDeFuncionarios.Repository;

import com.treinando_classes.demo.RH.ControleDePagamentosDeFuncionarios.Model.SalarioDescontado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface SalarioDescontadoRepository extends JpaRepository<SalarioDescontado , Long> {
    Optional<SalarioDescontado> findById_funcionario(long id_funcionario);

    @Query("select s from SalarioDescontado s where s.id_funcionario.id = :idFuncionario")
    List<SalarioDescontado> listarPorFuncionario(@Param("idFuncionario") long idFuncionario);
}