package com.fin.manager.modules.user.dto;

import com.fin.manager.modules.user.entity.User;

public record LoginContext(LoginRequestDTO loginRequestDTO, User user) {

    public LoginContext withUser(User user) {
        return new LoginContext(this.loginRequestDTO, user);
    }
}
