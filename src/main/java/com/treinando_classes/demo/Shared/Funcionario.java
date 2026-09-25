package com.treinando_classes.demo.Shared;

import com.treinando_classes.demo.DefinirCargos;
import jakarta.persistence.*;
import lombok.*;
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
    private String endereco;

    @Column(nullable = false)
    private String telefone;

    @JoinColumn(name = "id_cargo", referencedColumnName = "id")
    private DefinirCargos IdCargo;

    @JoinColumn(name = "id_empresa",referencedColumnName = "id")
    private Empresa id_empresa;

    @Column(nullable = false)
    private java.time.LocalDate data_admissao;
}