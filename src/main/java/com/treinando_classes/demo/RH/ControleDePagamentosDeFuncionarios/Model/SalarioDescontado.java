package com.treinando_classes.demo.RH.ControleDePagamentosDeFuncionarios.Model;

import com.treinando_classes.demo.Shared.Funcionario;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "salario_descontado")
@Entity
public class SalarioDescontado {
    @GeneratedValue
    @Id
    private long id;

    @OneToOne
    @JoinColumn(name = "id_FolhaDePagamento", referencedColumnName = "id")
    private FolhaDePagamento id_FolhaDePagamento;

    @OneToOne
    @JoinColumn(name = "id_funcionario")
    private Funcionario funcionario;

    @Column(nullable = false)
    private BigDecimal total_beneficio;
    @Column
    private BigDecimal total_horas;
    @Version
    private Long version;
}
