package com.treinando_classes.demo;

import com.treinando_classes.demo.Shared.Empresa;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "cargo")
@Entity
public class DefinirCargos {
    @GeneratedValue
    @Column
    @Id
    private long id;

    @Column(nullable = false)
    private String NomeDoCargo;

    @JoinColumn(name = "id_empresa", referencedColumnName = "id")
    private Empresa id_empresa;
}
