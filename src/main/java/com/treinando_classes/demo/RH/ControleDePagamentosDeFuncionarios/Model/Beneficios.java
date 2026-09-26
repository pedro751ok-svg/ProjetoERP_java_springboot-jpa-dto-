package com.treinando_classes.demo.RH.ControleDePagamentosDeFuncionarios.Model;

import com.treinando_classes.demo.RH.ControleDePagamentosDeFuncionarios.Domain.EnumBeneficios;
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
    private EnumBeneficios.Periodicidade Periodicidade;

    @Column(nullable = false)
    private boolean Ativo;

    @Column
    private String Fornecedor;

    @Column
    private EnumBeneficios.Tipo_De_Calculo TipoDeCalculo;
}
