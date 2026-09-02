package com.treinando_classes.demo.RH.models;

import jakarta.persistence.*;
import lombok.*;
import com.treinando_classes.demo.RH.regras_Enums.RegrasDeEnums;

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

    @Column
    private RegrasDeEnums.MeioDeAfastamento tipo;

    @Column
    private String descricao;

    @Column
    private Date data_emissao;

}
