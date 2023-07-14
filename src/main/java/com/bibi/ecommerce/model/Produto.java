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

    @Column(name = "estoquePP")
    private int estoquePP;

    @Column(name = "estoqueP")
    private int estoqueP;

    @Column(name = "estoqueM")
    private int estoqueM;

    @Column(name = "estoqueG")
    private int estoqueG;

    @Column(name = "estoqueGG")
    private int estoqueGG;

    @Column(name = "preco", nullable = false)
    private BigDecimal preco = new BigDecimal(0);

    @Enumerated(EnumType.STRING)
    private CategoriaProduto categoria;

    @OneToMany(fetch = FetchType.LAZY)
    private Set<Item> itens = new HashSet<>(0);
}
