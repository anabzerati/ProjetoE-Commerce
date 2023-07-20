package com.bibi.ecommerce.dao;

import com.bibi.ecommerce.model.Role;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
@Transactional
public class RoleDAO {

    @PersistenceContext
    private EntityManager manager;

    public Role find(int id){
        return manager.find(Role.class, id);
    }

    public Role find(String nome){
        return manager.createQuery("from Role where nome like :nome", Role.class)
                .setParameter("nome", nome).getSingleResult();
    }
}
