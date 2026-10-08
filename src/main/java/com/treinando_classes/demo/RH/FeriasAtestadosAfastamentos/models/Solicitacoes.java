package com.treinando_classes.demo.RH.FeriasAtestadosAfastamentos.models;
import com.treinando_classes.demo.RH.regras_Enums.RegrasDeEnums;
import com.treinando_classes.demo.Shared.Funcionario;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

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
    @Column(name = "status")
    private RegrasDeEnums.status status = RegrasDeEnums.status.PENDENTE;

    @ManyToOne
    @JoinColumn(name = "funcionario", referencedColumnName = "id")
    private Funcionario id_funcionario;

    @OneToOne
    @JoinColumn(name = "id_tipo", referencedColumnName = "id")
    private TipodeSolicitacao id_tipo;

    @ManyToOne
    @JoinColumn(name = "aceita_por_id", referencedColumnName = "id")
    private Funcionario aceita_por;

    @ManyToOne
    @JoinColumn(name = "rejeitado_por_id", referencedColumnName = "id")
    private Funcionario rejeitado_por;

    @OneToOne
    @JoinColumn(name = "ferias", referencedColumnName = "id")
    private Ferias id_ferias;

    @OneToOne
    @JoinColumn(name = "atestado", referencedColumnName = "id")
    private Atestado atestado_id;

    @OneToOne
    @JoinColumn(name = "afastamento", referencedColumnName = "id")
    private Afastamento afastamento_id;

    @Version
    private Long version;

    private LocalDate DataInicio;
    private LocalDate DataFim;

    private LocalDate AprovadoEm;
    private LocalDate Reprovadoem;
}
