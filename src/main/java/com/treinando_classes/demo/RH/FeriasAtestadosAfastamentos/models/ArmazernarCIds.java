package com.treinando_classes.demo.RH.FeriasAtestadosAfastamentos.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "cids armazenados")
public class ArmazernarCIds {
    @Id
    @GeneratedValue
    private long id;

    @Column(nullable = false)
    private String NumeroCid;

    @Column(nullable = false)
    private String Categoria;

    @Column(nullable = false)
    private String Descricao;
}
