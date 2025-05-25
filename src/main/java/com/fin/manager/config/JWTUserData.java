package com.fin.manager.config;

import lombok.Builder;

@Builder
public record JWTUserData(Long userId, String email) {
}
