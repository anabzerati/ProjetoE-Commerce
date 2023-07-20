package com.bibi.ecommerce.controller;

import com.bibi.ecommerce.model.Usuario;
import com.bibi.ecommerce.service.UsuarioService;
import com.bibi.ecommerce.util.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.persistence.PersistenceException;

@Controller
public class CadastrarUsuarioController {

    @Autowired
    UsuarioService usuarioService;

    @PostMapping("/")
    public String cadastrar(Usuario usuario, BindingResult result, Model model, RedirectAttributes redirectAttributes){
        if (result.hasErrors()) {
            model.addAttribute("message", Message.fieldsErrors());
            return "index";
        }

        try {
            usuarioService.cadastrar(usuario);

            // Redirecionamento bem-sucedido com mensagem de sucesso
            redirectAttributes.addFlashAttribute("message", Message.successMessage("Usuário cadastrado com sucesso"));
        } catch (PersistenceException erro) {
            erro.printStackTrace();
            redirectAttributes.addFlashAttribute("message", Message.errorMessage("Seus dados já foram cadastrados no sistema."));
        } catch (Exception erro) {
            erro.printStackTrace();
            redirectAttributes.addFlashAttribute("message", Message.internalError());
        }

        return "redirect:/";
    }

}
