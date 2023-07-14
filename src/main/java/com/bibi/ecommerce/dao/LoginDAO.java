package com.bibi.ecommerce.dao;

import com.bibi.ecommerce.model.Usuario;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class LoginDAO implements UserDetailsService {
    @PersistenceContext
    private EntityManager manager;

    @Override
    public UserDetails loadUserByUsername(String email) {
        List<Usuario> usuarios = manager.createQuery("select u from Usuario u " +
                        "left join fetch u.roles " +
                        "where u.email = :email", Usuario.class)
                .setParameter("email", email)
                .getResultList();

        if (usuarios.isEmpty()) {
            throw new RuntimeException("O usuário não foi encontrado");
        }

        return usuarios.get(0);
    }
}
