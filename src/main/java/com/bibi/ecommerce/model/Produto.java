package com.bibi.ecommerce.model;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_produto")
    private int id;

    @Column(name = "estoque_PP")
    private int estoquePP;

    @Column(name = "estoque_P")
    private int estoqueP;

    @Column(name = "estoque_M")
    private int estoqueM;

    @Column(name = "estoque_G")
    private int estoqueG;

    @Column(name = "estoque_GG")
    private int estoqueGG;

    @Column(name = "preco", nullable = false)
    private BigDecimal preco = new BigDecimal(0);

    @Enumerated(EnumType.STRING)
    private CategoriaProduto categoria;

    @OneToMany(fetch = FetchType.LAZY)
    private Set<Item> itens = new HashSet<>(0);
}
