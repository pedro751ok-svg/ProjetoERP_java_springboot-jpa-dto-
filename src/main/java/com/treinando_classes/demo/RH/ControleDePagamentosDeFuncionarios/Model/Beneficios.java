package com.treinando_classes.demo.RH.ControleDePagamentosDeFuncionarios.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "beneficios")
@Entity
public class Beneficios {
    @GeneratedValue
    @Column
    private long id;

    @Column(nullable = false)
    private String TipoDeBeneficio;

    @Column(nullable = false)
    private LocalTime Periodicidade;

    @Column(nullable = false)
    private boolean Ativo;

    @Column
    private String Fornecedor;

    @Column
    private String TipoDeCalculo;
}
