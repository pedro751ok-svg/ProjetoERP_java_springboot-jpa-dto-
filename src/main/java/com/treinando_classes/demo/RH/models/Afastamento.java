package com.treinando_classes.demo.RH.models;
import jakarta.persistence.*;
import lombok.*;
import com.treinando_classes.demo.RH.regras_Enums.RegrasDeEnums;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "afastamento")
@Entity
public class Afastamento{

    @GeneratedValue
    @Id
    private long id;

    @ManyToOne
    @JoinColumn(name = "id_solicitacoes")
    private Solicitacoes id_solicitacoes;

    @Column(nullable = false)
    private RegrasDeEnums.TipoInss motivo;
}

