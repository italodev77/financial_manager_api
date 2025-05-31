package com.fin.manager.User.adapters;

import com.fin.manager.User.entity.User;

public interface TokenProvider {
    String generateToken(User user);
}
