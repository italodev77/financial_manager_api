package com.fin.manager.modules.user.service;

import com.fin.manager.config.TokenService;
import com.fin.manager.modules.user.dto.LoginContext;
import com.fin.manager.modules.user.dto.LoginRequestDTO;
import com.fin.manager.modules.user.handler.ChainBuilder;
import com.fin.manager.modules.user.handler.Handler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    @Autowired
    private ChainBuilder chainBuilder;

    @Autowired
    private TokenService tokenService;

    public String processLogin(LoginRequestDTO loginRequestDTO) {
        Handler chain = chainBuilder.buildChain();
        LoginContext context = new LoginContext(loginRequestDTO);
        chain.handle(context);
        return tokenService.generateToken(context.getUser());
    }
}