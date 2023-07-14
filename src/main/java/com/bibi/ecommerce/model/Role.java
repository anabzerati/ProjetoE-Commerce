package com.bibi.ecommerce.model;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;

@Entity
@Data
public class Role implements GrantedAuthority {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_role")
    private int id;

    @Column(name = "nome")
    private String nome;

    public Role() {
    }

    @Override
    public String getAuthority() {
        return this.nome;
    }
}
