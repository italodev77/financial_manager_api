package com.fin.manager.modules.user.handler;

import com.fin.manager.modules.user.dto.LoginContext;
import com.fin.manager.modules.user.entity.User;
import com.fin.manager.modules.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(1)
public class UserExistenceHandler implements Handler {

    @Autowired
    private UserRepository userRepository;

    private Handler next;

    @Override
    public void setNext(Handler next) {
        this.next = next;
    }

    @Override
    public void handle(LoginContext context) {
        String email = context.getLoginRequestDTO().email();

        User user = (User) userRepository.findByEmail(email)
                .orElseThrow(() -> new IllegalArgumentException("Usuário não encontrado"));

        context.setUser(user);

        System.out.println("Usuário encontrado: " + user.getEmail());

        if (next != null) {
            next.handle(context);
        }
    }
}