package com.fin.manager.User.infra.securityConfig;

import lombok.Builder;

@Builder
public record JWTUserData(Long userId, String email) {
}
