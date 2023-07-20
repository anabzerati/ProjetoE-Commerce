package com.bibi.ecommerce.service;

import com.bibi.ecommerce.dao.RoleDAO;
import com.bibi.ecommerce.dao.UsuarioDAO;
import com.bibi.ecommerce.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;

public class UsuarioService {
    @Autowired
    private UsuarioDAO usuarioDAO;

    @Autowired
    private RoleDAO roleDAO;

    @Autowired
    private PasswordEncoder encoder;

    public void cadastrar(Usuario novoUsuario) {
        /* Criptografa a senha do cliente para salvar na base de dados. */
        novoUsuario.setSenha(encoder.encode(novoUsuario.getSenha()));

        novoUsuario.adicionar(roleDAO.find("ROLE_USER"));

        usuarioDAO.salvar(novoUsuario);
    }

    public Usuario buscarPorId(Integer id) {
        return usuarioDAO.find(id);
    }

    public List<Usuario> buscarUsuarios() {
        return usuarioDAO.buscar();
    }

}
