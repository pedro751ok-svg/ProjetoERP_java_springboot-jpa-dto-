package com.treinando_classes.demo.RH.ControleDePagamentosDeFuncionarios.Repository;


import com.treinando_classes.demo.RH.ControleDePagamentosDeFuncionarios.Model.FolhaDePagamento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FolhaPagamentoRepository extends JpaRepository<FolhaDePagamento, Long> {
    Optional<FolhaDePagamento>findById_funcionario(Long id_funcionario);
}