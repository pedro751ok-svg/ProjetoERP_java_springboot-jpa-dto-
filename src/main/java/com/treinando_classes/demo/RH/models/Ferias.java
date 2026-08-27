package com.treinando_classes.demo.RH.models;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "ferias")
@Entity
public class Ferias {
    @GeneratedValue
    @Id
    private long id;

    @ManyToOne
    @JoinColumn(name = "solicitacao_id")
    private Solicitacoes solicitacao_id;

    private LocalDateTime data_inicio;
    private LocalDateTime data_fim;
}
