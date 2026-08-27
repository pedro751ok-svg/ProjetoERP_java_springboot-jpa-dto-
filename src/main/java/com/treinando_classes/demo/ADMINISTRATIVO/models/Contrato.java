package com.treinando_classes.demo.ADMINISTRATIVO.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "contrato")
@Entity
public class Contrato {
    @Id
    @GeneratedValue
    private long id;

    @Column(nullable = false)
    private Date data_inicio;

    @Column(nullable = false)
    private Date data_fim;

    @Column(nullable = false)
    private String vigencia;

}
