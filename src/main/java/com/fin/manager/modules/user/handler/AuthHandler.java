package com.fin.manager.modules.user.handler;

import com.fin.manager.modules.user.dto.LoginContext;
import com.fin.manager.modules.user.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@Order(3)
public class AuthHandler implements Handler {

    private Handler next;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void setNext(Handler next) {
        this.next = next;
    }

    @Override
    public void handle(LoginContext context) {
        User user = context.getUser();

        if (user == null) {
            throw new RuntimeException("Usuário não encontrado para autenticação.");
        }

        String rawPassword = context.getLoginRequestDTO().password();
        String encodedPassword = user.getPassword();

        if (!passwordEncoder.matches(rawPassword, encodedPassword)) {
            throw new RuntimeException("Senha incorreta.");
        }

        System.out.println("Autenticação concluída.");

        if (next != null) {
            next.handle(context);
        }
    }
}
