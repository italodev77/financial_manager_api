package com.fin.manager.modules.user.handler;

import com.fin.manager.modules.user.dto.LoginContext;
import com.fin.manager.modules.user.entity.User;
import com.fin.manager.modules.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(2)
public class UserExistenceHandler implements Handler {

    private Handler next;

    @Autowired
    private UserRepository userRepository;

    @Override
    public void setNext(Handler next) {
        this.next = next;
    }

    @Override
    public void handle(LoginContext context) {
        String email = context.loginRequestDTO().email();
        User user = (User) userRepository.findByEmail(email)
                .orElseThrow(() -> new IllegalArgumentException("Usuário não encontrado"));

        System.out.println("Usuário encontrado.");

        LoginContext updatedContext = context.withUser(user);

        if (next != null) {
            next.handle(updatedContext);
        }
    }
}