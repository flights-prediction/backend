package com.backend.aiplane.domain.token.application;

import com.backend.aiplane.domain.token.application.dto.response.TokenResponse;

public interface TokenService {
    TokenResponse reissueAccessToken(String authorizationHeader);
}
