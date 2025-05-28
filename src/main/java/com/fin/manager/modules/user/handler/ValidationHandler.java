package com.fin.manager.modules.user.handler;

import com.fin.manager.domain.entity.user.dto.LoginContext;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(1)
public class ValidationHandler implements Handler {

    private Handler next;

    @Override
    public void setNext(Handler next) {
        this.next = next;
    }

    @Override
    public void handle(LoginContext context) {
        var request = context.getLoginRequestDTO();
        if (request.email() == null || request.email().isBlank() ||
                request.password() == null || request.password().isBlank()) {
            throw new IllegalArgumentException("Email e senha são obrigatórios.");
        }
        System.out.println("Validação concluída.");
        if (next != null) {
            next.handle(context);
        }
    }
}