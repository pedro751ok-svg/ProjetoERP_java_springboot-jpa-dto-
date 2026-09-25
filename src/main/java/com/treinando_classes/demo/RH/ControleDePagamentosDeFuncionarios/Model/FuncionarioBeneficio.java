package com.treinando_classes.demo.RH.ControleDePagamentosDeFuncionarios.Model;

import com.treinando_classes.demo.Shared.Funcionario;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.transaction.event.TransactionalEventListener;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "funcionario_beneficio")
@Entity
public class FuncionarioBeneficio {
    @GeneratedValue
    @Column
    @Id
    private long id;

    @Column(nullable = false)
    private LocalDateTime DataInicio;

    @Column(nullable = false)
    private LocalDateTime DataFim;

    @Column(nullable = false)
    private BigDecimal ValorEfetivo;

    @OneToOne
    @JoinColumn(name = "id_funcinario",referencedColumnName = "id")
    private Funcionario id_funcionario;

    @ManyToOne
    @JoinColumn(name = "id_beneficio", referencedColumnName = "id")
    private Beneficios id_beneficio;
}
