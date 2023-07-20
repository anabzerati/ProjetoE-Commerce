package com.bibi.ecommerce.dao;

import com.bibi.ecommerce.model.Usuario;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class UsuarioDAO {
    @PersistenceContext
    private EntityManager manager;

    public List<Usuario> buscar() {
        return manager.createQuery("SELECT u FROM Usuario u", Usuario.class).getResultList();
    }

    public Usuario find(int id) {
        return manager.find(Usuario.class, id);
    }

    public void salvar(Usuario usuario) {
        manager.persist(usuario);
    }

    public void atualizar(Usuario usuario) { manager.merge(usuario); }
}
