package com.treinando_classes.demo.RH.models;

import jakarta.persistence.*;
import lombok.*;
import com.treinando_classes.demo.RH.regras_Enums.RegrasDeEnums;
import com.treinando_classes.demo.Shared.Funcionario;

import java.time.LocalDate;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "tipo_de_solicitacao")
@Entity
public class TipodeSolicitacao {
    @GeneratedValue
    @Id
    private long id;

    @ManyToOne
    @JoinColumn(name = "id_funcuionario" , referencedColumnName = "id")
    private  Funcionario funcionario_id;
    @Column
    private RegrasDeEnums.MeioDeAfastamento tipo;

    @Column
    private String descricao;

    @Column
    private LocalDate data_emissao;

}
