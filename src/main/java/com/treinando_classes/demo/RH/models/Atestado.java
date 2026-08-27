package com.treinando_classes.demo.RH.models;
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

     @ManyToOne
     @JoinColumn(name = "solicitacao_id")
     private Solicitacoes solicitacao_id;

     @Column(nullable = false)
     private String cid;
}
