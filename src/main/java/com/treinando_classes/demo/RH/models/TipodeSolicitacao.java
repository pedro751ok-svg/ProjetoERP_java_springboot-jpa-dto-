package com.treinando_classes.demo.RH.models;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;
import com.treinando_classes.demo.RH.regras_Enums.RegrasDeEnums;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "tipo_de_solicitacao")
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
