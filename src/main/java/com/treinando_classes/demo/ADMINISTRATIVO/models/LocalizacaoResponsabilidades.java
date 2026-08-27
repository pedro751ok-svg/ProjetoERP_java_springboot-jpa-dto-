package com.treinando_classes.demo.ADMINISTRATIVO.models;

import jakarta.persistence.*;
import lombok.*;
import com.treinando_classes.demo.EnumsDaRaiz.EnumsParaUsoGeral;
import com.treinando_classes.demo.Shared.Funcionario;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "localizacao_responsabilidades")
@Entity
public class LocalizacaoResponsabilidades {

    @GeneratedValue
    @Id
    private long id;

    @Column
    private EnumsParaUsoGeral.Setor id_setor;

    @Column
    private String localizacao;

    @Column
    private Funcionario responsavel_id;
}
