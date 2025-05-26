package com.fin.manager.modules.user.dto;

import com.fin.manager.modules.user.dto.LoginRequestDTO;
import com.fin.manager.modules.user.entity.User;

public class LoginContext {
    private final LoginRequestDTO loginRequestDTO;
    private User user;
    private String jwtToken;

    public LoginContext(LoginRequestDTO loginRequestDTO) {
        this.loginRequestDTO = loginRequestDTO;
    }

    public LoginRequestDTO getLoginRequestDTO() {
        return loginRequestDTO;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getJwtToken() {
        return jwtToken;
    }

    public void setJwtToken(String jwtToken) {
        this.jwtToken = jwtToken;
    }
}
