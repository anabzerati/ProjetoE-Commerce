package com.bibi.ecommerce.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_item")
    private int id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_produto")
    private Produto produto;

    @Enumerated(EnumType.STRING)
    private TamanhoItem tamanho;
}
