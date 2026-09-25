package com.treinando_classes.demo.RH.ControleDePagamentosDeFuncionarios.Model;

import com.treinando_classes.demo.DefinirCargos;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "cargo_beneficio")
@Entity
public class BeneficioDeCargo {
    @GeneratedValue
    @Column
    @Id
    private long id;

    @OneToOne
    @JoinColumn(name = "id_cargo",referencedColumnName = "id")
    private DefinirCargos IdCargo;

    @Column(nullable = false)
    private BigDecimal ValorPadrao;

    @Column(nullable = false)
    private LocalDate VigenciaInicio;

    @Column(nullable = false)
    private LocalDate VigenciaFim;

    @OneToOne
    @JoinColumn(name = "id_beneficio", referencedColumnName = "id")
    private Beneficios IdeBeneficio;


}
