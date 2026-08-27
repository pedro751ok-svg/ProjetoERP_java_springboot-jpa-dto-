package com.treinando_classes.demo.ADMINISTRATIVO.models;

import jakarta.persistence.*;
import com.treinando_classes.demo.ADMINISTRATIVO.Domain.Enums;

import java.util.Date;

public class Controlle {
    @GeneratedValue
    @Id
    private long id;

    @Column(nullable = false)
    private Enums.StatusPatrimonio status;

    @Column
    private Date data_de_baixa;

    @Column
    private Date motivo_da_baixa;

    @OneToOne
    @JoinColumn(name = "Controlle_patrimonio", referencedColumnName = "id")
    private Patrimonio patrimonio_id;

}
