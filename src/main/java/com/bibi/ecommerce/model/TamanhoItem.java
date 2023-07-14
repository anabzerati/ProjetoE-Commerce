package com.bibi.ecommerce.model;

public enum TamanhoItem {
    PP("PP", 0),
    P("P", 1),
    M("M", 2),
    G("G", 3),
    GG("GG", 4);


    private final String label;

    private final Integer order;

    TamanhoItem(String label, Integer order) {
        this.label = label;
        this.order = order;
    }

    public String getLabel() { return label; }

    public Integer getOrder() {
        return order;
    }
}
