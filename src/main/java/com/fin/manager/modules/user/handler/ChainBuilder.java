package com.fin.manager.modules.user.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ChainBuilder {

    private final List<Handler> handlers;

    @Autowired
    public ChainBuilder(List<Handler> handlers) {
        this.handlers = handlers;
    }

    public Handler buildChain() {
        if (handlers.isEmpty()) {
            throw new IllegalStateException("Nenhum handler configurado.");
        }
        for (int i = 0; i < handlers.size() - 1; i++) {
            handlers.get(i).setNext(handlers.get(i + 1));
        }
        return handlers.get(0);
    }
}