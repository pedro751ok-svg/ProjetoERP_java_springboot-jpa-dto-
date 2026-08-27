package com.treinando_classes.demo.ADMINISTRATIVO.models;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ManyToAny;
import org.springframework.data.annotation.Id;
import com.treinando_classes.demo.ADMINISTRATIVO.models.LocalizacaoResponsabilidades;
import com.treinando_classes.demo.ADMINISTRATIVO.models.FichaVistoria;
import com.treinando_classes.demo.ADMINISTRATIVO.models.Controlle;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "patrimonio")
@Entity
public class Patrimonio {
    @GeneratedValue
    @Id
    private long id;

    @Column
    private String codigo_de_indentificacao;

    @Column(nullable = false)
    private String nome_do_item;

    @Column(nullable = false)
    private String descricao_do_item;

    @Column(nullable = false)
    private String condicoes_do_item;

    @ManyToOne
    @JoinColumn(name = "id_localizacao_e_responsabilidades", referencedColumnName = "id")
    private LocalizacaoResponsabilidades controlle_de_responsabilidade_id;


}
