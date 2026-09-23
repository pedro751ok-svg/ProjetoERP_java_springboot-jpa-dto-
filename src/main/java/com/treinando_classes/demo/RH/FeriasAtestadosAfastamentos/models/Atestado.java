package com.treinando_classes.demo.RH.FeriasAtestadosAfastamentos.models;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "atestados")
@Entity
public class Atestado {
    @GeneratedValue
    @Id
    private long id;

     @OneToOne
     @JoinColumn(name = "solicitacao_id", referencedColumnName = "id")
     private Solicitacoes solicitacao_id;

     @Column(nullable = false)
     private String cid;
}
