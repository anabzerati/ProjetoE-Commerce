package com.bibi.ecommerce.util;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Message {

    private String title;

    private String message;

    private AlertType type;

    public static Message internalError() {
        return new Message(
                "Erro interno!",
                "Contate um administrador do sistema.",
                AlertType.danger
        );
    }

    public static Message fieldsErrors() {
        return new Message(
                "Erro!",
                "Por favor, verifique os dados preenchidos.",
                AlertType.warning
        );
    }

    public static Message successMessage(String message) {
        return new Message(
                "Sucesso!",
                message + "!",
                AlertType.success
        );
    }

    public static Message errorMessage(String message) {
        return new Message(
                "Erro!",
                message + ".",
                AlertType.warning
        );
    }

}
