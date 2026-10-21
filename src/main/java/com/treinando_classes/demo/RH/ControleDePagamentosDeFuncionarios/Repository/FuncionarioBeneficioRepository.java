package com.treinando_classes.demo.RH.ControleDePagamentosDeFuncionarios.Repository;

import com.treinando_classes.demo.RH.ControleDePagamentosDeFuncionarios.Model.Beneficios;
import com.treinando_classes.demo.RH.ControleDePagamentosDeFuncionarios.Model.FuncionarioBeneficio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface FuncionarioBeneficioRepository extends JpaRepository<FuncionarioBeneficio, Long> {

    @Query("select fb.id_beneficio from FuncionarioBeneficio fb where fb.id_funcionario.id = :idFuncionario")
    List<Beneficios> listarBeneficiosPorFuncionario(@Param("idFuncionario") long idFuncionario);
}