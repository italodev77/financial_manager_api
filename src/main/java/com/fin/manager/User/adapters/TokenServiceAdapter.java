package com.fin.manager.User.adapters;

import com.fin.manager.User.entity.User;
import com.fin.manager.User.infra.securityConfig.TokenService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TokenServiceAdapter implements TokenProvider {

    private final TokenService tokenService;

    @Override
    public String generateToken(User user) {
        return tokenService.generateToken(user);
    }
}