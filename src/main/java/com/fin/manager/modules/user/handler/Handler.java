package com.fin.manager.modules.user.handler;

import com.fin.manager.modules.user.dto.LoginContext;

public interface Handler {
    void setNext(Handler next);
    void handle(LoginContext context);
}
