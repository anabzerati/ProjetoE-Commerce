package com.bibi.ecommerce.util;

import com.bibi.ecommerce.model.Usuario;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
public class UsuarioLogado {

    public static Usuario getUsuario(){
        return (Usuario) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }

}
