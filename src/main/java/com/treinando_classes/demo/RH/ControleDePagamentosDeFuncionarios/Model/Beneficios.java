package com.treinando_classes.demo.RH.ControleDePagamentosDeFuncionarios.Model;

import com.treinando_classes.demo.RH.ControleDePagamentosDeFuncionarios.Domain.EnumBeneficios;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
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
    private BigDecimal ValorDoBeneficio;

    @Column(nullable = false)
    private boolean Ativo;

    @Column
    private String Fornecedor;

    @Column
    private EnumBeneficios.Tipo_De_Calculo TipoDeCalculo;

    @Version
    private Long version;
}
