package com.treinando_classes.demo.RH.ControleDePagamentosDeFuncionarios.Repository;


import com.treinando_classes.demo.RH.ControleDePagamentosDeFuncionarios.Model.FolhaDePagamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface FolhaPagamentoRepository extends JpaRepository<FolhaDePagamento, Long> {
    Optional<FolhaDePagamento>findById_funcionario(long id_funcionario);

    @Query("select f from FolhaDePagamento f where f.id_funcionario.id = :idFuncionario and f.mes = :mes")
    List<FolhaDePagamento> listarPorFuncionarioEMes(@Param("idFuncionario") long idFuncionario,
                                                    @Param("mes") int mes);
}