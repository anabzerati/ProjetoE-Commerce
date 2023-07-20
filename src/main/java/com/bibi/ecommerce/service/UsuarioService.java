package com.bibi.ecommerce.service;

import com.bibi.ecommerce.dao.RoleDAO;
import com.bibi.ecommerce.dao.UsuarioDAO;
import com.bibi.ecommerce.model.Role;
import com.bibi.ecommerce.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioDAO usuarioDAO;

    @Autowired
    private RoleDAO roleDAO;

    @Autowired
    private PasswordEncoder encoder;

    public void cadastrar(Usuario novoUser) {
        novoUser.setSenha(encoder.encode(novoUser.getSenha())); //criptografando senha para salvar na base de dados

        novoUser.adicionar(roleDAO.find("ROLE_USER"));

        usuarioDAO.salvar(novoUser);

    }
}
