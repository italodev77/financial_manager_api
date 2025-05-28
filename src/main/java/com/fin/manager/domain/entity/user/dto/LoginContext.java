package com.fin.manager.domain.entity.user.dto;

import com.fin.manager.adapters.out.entities.JpaUsuarioEntity;

public class LoginContext {
    private final LoginRequestDTO loginRequestDTO;
    private JpaUsuarioEntity user;
    private String jwtToken;

    public LoginContext(LoginRequestDTO loginRequestDTO) {
        this.loginRequestDTO = loginRequestDTO;
    }

    public LoginRequestDTO getLoginRequestDTO() {
        return loginRequestDTO;
    }

    public JpaUsuarioEntity getUser() {
        return user;
    }

    public void setUser(JpaUsuarioEntity user) {
        this.user = user;
    }

    public String getJwtToken() {
        return jwtToken;
    }

    public void setJwtToken(String jwtToken) {
        this.jwtToken = jwtToken;
    }
}
