package com.treinando_classes.demo.Shared;

import jakarta.persistence.*;
import lombok.*;
import com.treinando_classes.demo.RH.regras_Enums.RegrasDeEnums;
import com.treinando_classes.demo.EnumsDaRaiz.EnumsParaUsoGeral;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "funcionarios")
@Entity
public class Funcionario {

    @GeneratedValue
    @Id
    private long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false, unique = true)
    private String cpf;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String senha;

    @Column(nullable = false)
    private EnumsParaUsoGeral.Setor setor;

    @Column(nullable = false)
    private String endereço;

    @Column(nullable = false)
    private String telefone;

    @Column(nullable = false)
    private java.time.LocalDate data_admissao;
}