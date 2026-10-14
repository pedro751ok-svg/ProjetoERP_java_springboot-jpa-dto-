package com.treinando_classes.demo.RH.ControleDePagamentosDeFuncionarios.Repository;

import com.treinando_classes.demo.RH.ControleDePagamentosDeFuncionarios.Model.SalarioDescontado;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SalarioDescontadoRepository extends JpaRepository<SalarioDescontado , Long> {

}
