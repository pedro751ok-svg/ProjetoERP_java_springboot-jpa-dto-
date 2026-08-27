package com.treinando_classes.demo.ADMINISTRATIVO.models;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "vistoriador")
@Entity
public class DadoVistoriador {
    @GeneratedValue
    @Id
    private long id;

    @Column
    private String nome;

    @Column
    private String assinatura_digital;

    @Column
    private String cargo;
}
