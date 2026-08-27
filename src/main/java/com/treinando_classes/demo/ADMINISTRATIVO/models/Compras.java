package com.treinando_classes.demo.ADMINISTRATIVO.models;
import com.treinando_classes.demo.ADMINISTRATIVO.models.ItemComprado;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "compras")
@Entity
public class Compras {
    @Id
    @GeneratedValue
    private long id;

    @Column(nullable = false)
    private String status;

    @Column(nullable = false)
    private Date data_compra;

    @Column(nullable = false)
    private Double valor_total;

    @Column(nullable = false)
    private String fornecedor;

    @ManyToOne
    @JoinColumn(name = "id_item", referencedColumnName = "id")
    private ItemComprado itemcomprado ;
}
