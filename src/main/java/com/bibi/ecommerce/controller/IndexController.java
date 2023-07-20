package com.bibi.ecommerce.controller;

import com.bibi.ecommerce.model.Usuario;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

public class IndexController {
    @GetMapping("/")
    public String index(Model model) {
        Usuario teste = new Usuario(1,"A", "B", "C", null);
        model.addAttribute("usuario", teste);
        return "index";
    }
}
