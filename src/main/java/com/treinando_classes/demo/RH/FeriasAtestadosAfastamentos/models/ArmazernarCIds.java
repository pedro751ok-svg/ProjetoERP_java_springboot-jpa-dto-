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
@Table(name = "cids_armazenados")
public class ArmazernarCIds {
    @Id
    @GeneratedValue
    private long id;

    @Column(nullable = false,unique = true,length = 7)
    private String numeroCid;

    @Column(nullable = false)
    private String categoria;

    @Column(nullable = false,columnDefinition = "TEXT")
    private String descricao;
}
