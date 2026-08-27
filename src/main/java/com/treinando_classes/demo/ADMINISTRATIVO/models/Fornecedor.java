package com.treinando_classes.demo.ADMINISTRATIVO.models;
import jakarta.persistence.*;
import lombok.*;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "fornecedores")
@Entity
public class Fornecedor {

        @Id
        @GeneratedValue
        private long id;

        @Column(nullable = false)
        private String nome_do_fornecedor;

        @Column(nullable = false)
        private String cnpj;

        @Column(nullable = false)
        private String email;

        @Column(nullable = false)
        private String telefone;

        @Column(nullable = false)
        private String endereco;

        @Column(nullable = false)
        private String status;

        @Column(nullable = false)
        private String nome_produto;

        @ManyToOne
        @JoinColumn(name ="id_contrato",referencedColumnName = "id")
        private Contrato id_contrato_fornecedor;
}
