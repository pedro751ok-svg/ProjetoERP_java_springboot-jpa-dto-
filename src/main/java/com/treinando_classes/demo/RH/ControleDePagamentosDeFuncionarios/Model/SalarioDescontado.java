package com.treinando_classes.demo.RH.ControleDePagamentosDeFuncionarios.Model;

import com.treinando_classes.demo.Shared.Funcionario;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "salario_descontado")
@Entity
public class SalarioDescontado {
    @GeneratedValue
    @Column
    @Id
    private long id;

    @OneToOne
    @JoinColumn(name = "id_FolhaDePagamento", referencedColumnName = "id")
    private FolhaDePagamento id_FolhaDePagamento;

    @OneToOne
    @JoinColumn(name = "id_funcionario", referencedColumnName = "id")
    private Funcionario id_funcionario;

    @Column(nullable = false)
    private double total;
}
