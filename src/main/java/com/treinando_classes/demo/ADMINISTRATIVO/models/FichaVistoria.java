package com.treinando_classes.demo.ADMINISTRATIVO.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "ficha_vistoria")
@Entity
public class FichaVistoria {
    @GeneratedValue
    @Id
    private long id;

    @Column
    private String codigo_vistoria;

    @Column
    private Date data_inicio;

    @Column
    private Date data_fim;

    @OneToMany
    @JoinColumn(name = "informações do vistoriador", referencedColumnName = "id")
    private DadoVistoriador id_dados_vistoriador;

    @ManyToOne
    @JoinColumn(name = "estado_atual_vistoria", referencedColumnName = "id")
    private Patrimonio patrimonio_id;

}
