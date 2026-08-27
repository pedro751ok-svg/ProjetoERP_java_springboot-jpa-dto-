package com.treinando_classes.demo.ADMINISTRATIVO.models;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "itemcomprado")
@Entity
public class ItemComprado {
    @Id
    @GeneratedValue
    private long id;

    @Column(nullable = false)
    private String item;

    @Column(nullable = false)
    private int quantidade_comprada;

    @Column(nullable = false)
    private int quantidade_recebida;

    @Column(nullable = false)
    private String voluntario;

}
