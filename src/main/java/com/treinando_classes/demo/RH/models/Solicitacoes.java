package com.treinando_classes.demo.RH.models;
import com.treinando_classes.demo.RH.regras_Enums.RegrasDeEnums;
import com.treinando_classes.demo.Shared.Funcionario;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "solicitacoes")
public class Solicitacoes {
    @GeneratedValue
    @Id
    private long id;

    @ManyToOne
    @JoinColumn(name = "funcionario")
    private Funcionario funcionario;

    @ManyToOne
    @JoinColumn(name = "aceita_por_id", referencedColumnName = "id")
    private Funcionario aceita_por;

    @Column(name = "status")
    private RegrasDeEnums.status status = RegrasDeEnums.status.PENDENTE;

    @ManyToOne
    @JoinColumn(name = "rejeitado_por_id", referencedColumnName = "id")
    private Funcionario rejeitado_por;

    private LocalDateTime DataIncio;
    private LocalDateTime DataFim;

    private LocalDateTime CriadoEm;
    private LocalDateTime AprovadoEm;
    private LocalDateTime Reprovadoem;
}
