package com.bibi.ecommerce.model;

public enum CategoriaProduto {
    CAMISETA("Camiseta", 0),
    CAMISA("Camisa", 1),
    CALCA("Calça", 2),
    VESTIDO("Vestido", 3),
    SAIA("Saia", 4);


    private final String label;

    private final Integer order;

    CategoriaProduto(String label, Integer order) {
        this.label = label;
        this.order = order;
    }

    public String getLabel() { return label; }

    public Integer getOrder() {
        return order;
    }
}
