package com.treinando_classes.demo.RH.ControleDePagamentosDeFuncionarios.Repository;

import com.treinando_classes.demo.RH.ControleDePagamentosDeFuncionarios.Model.Beneficios;
import org.hibernate.sql.results.graph.entity.internal.BatchEntitySelectFetchInitializer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface  BeneficiosRepository extends JpaRepository<Beneficios , Long> {
    Optional<Beneficios>findByTipoDeBeneficio(String TipoDeBenefcio);
    Optional<Beneficios>findById_funcionario(long Id_funcionario);

    @Query("select b from Beneficios b where b.Ativo = true")
    List<Beneficios> listarAtivos();
}