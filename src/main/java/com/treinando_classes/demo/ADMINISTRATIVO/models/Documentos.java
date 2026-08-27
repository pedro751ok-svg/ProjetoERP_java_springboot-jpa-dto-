package com.treinando_classes.demo.ADMINISTRATIVO.models;
import com.treinando_classes.demo.Shared.Funcionario;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "documentos")
@Entity
public class Documentos {
    @Id
    @GeneratedValue
    private long id;

    @Column(nullable = false)
    private String tipo_de_documento;

    @Column(nullable = false)
    private Double numero_do_documento;

    @Column(nullable = false)
    private LocalDateTime data_de_emissao;

    @Column(nullable = false)
    private String arquivo;

    @Column(nullable = false)
    private Funcionario id_funcionario;

    @Column
    private Patrimonio id_patrimonio;


}
