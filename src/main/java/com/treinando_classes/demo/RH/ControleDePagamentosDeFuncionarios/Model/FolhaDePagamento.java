package com.treinando_classes.demo.RH.ControleDePagamentosDeFuncionarios.Model;

import com.fasterxml.jackson.databind.annotation.EnumNaming;
import com.treinando_classes.demo.Shared.Funcionario;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "folha_de_pagamento")
@Entity
public class FolhaDePagamento {
    @Column
    @GeneratedValue
    private long id;

    @JoinColumn(name = "id_funcionario", referencedColumnName ="id")
    @OneToOne
    @Column
    private Funcionario id_funcionario;

    @Column(nullable = false)
    private double Salario;

    @Column(nullable = false)
    private double TotalDescontos;

    @Column(nullable = false)
    private LocalTime HorasTrabalhadas;

    @Column(nullable = false)
    private LocalTime HorasExtras;

    @Column(nullable = false)
    private double ValorGanhoPorHora;

    @Column(nullable = false)
    private int mes;

    @Column(nullable = false)
    private int dia;


}
