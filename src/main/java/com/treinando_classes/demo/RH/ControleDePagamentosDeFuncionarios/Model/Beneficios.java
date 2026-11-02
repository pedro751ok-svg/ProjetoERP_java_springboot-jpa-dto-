package com.treinando_classes.demo.RH.ControleDePagamentosDeFuncionarios.Model;

import com.treinando_classes.demo.RH.ControleDePagamentosDeFuncionarios.Domain.EnumBeneficios;
import com.treinando_classes.demo.Shared.Funcionario;
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
    @Id
    private long id;

    @Column(nullable = false)
    private String tipoDeBeneficio;

    @Column(nullable = false)
    private EnumBeneficios.Periodicidade periodicidade;

    @Column(nullable = false)
    private BigDecimal valorDoBeneficio;

    @Column(nullable = false)
    private boolean Ativo;

    @Column
    private String fornecedor;

    @Column
    private EnumBeneficios.Tipo_De_Calculo TipoDeCalculo;

    @Version
    private Long version;

    @ManyToOne
    @JoinColumn(name = "funcionario_id")
    private Funcionario funcionario;
}
