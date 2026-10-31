package com.treinando_classes.demo.Shared;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "empresas")
@Entity
public class Empresa {

    @GeneratedValue
    @Id
    private long id;

    @Column(nullable = false)
    private String nome_empresa;

    @Column(nullable = false, unique = true)
    private String cnpj;

    @Column(nullable = false, unique = true)
    private String emailCorporativo;

    @Column(nullable = false)
    private String senha;
}