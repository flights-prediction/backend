package com.backend.aiplane.domain.token.presentation;

import com.backend.aiplane.domain.token.application.TokenService;
import com.backend.aiplane.domain.token.application.dto.response.TokenResponse;
import com.backend.aiplane.global.response.SuccessCode;
import com.backend.aiplane.global.response.SuccessResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Token API", description = "Token API Controller입니다.")
@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class TokenController {
    private final TokenService authService;

    // 액세스 토큰을 재발행하는 API
    @Operation(summary = "Token API", description = "Access-Token 재발행 API입니다. ")
    @GetMapping("/reissue/access-token")
    public ResponseEntity<SuccessResponse<TokenResponse>> reissueAccessToken(
            @Parameter(description = "Refresh Token을 넣어 주세요")
            @RequestHeader("Authorization") String authorizationHeader) {

        TokenResponse accessToken = authService.reissueAccessToken(authorizationHeader);
        return SuccessResponse.of(SuccessCode.TOKEN_CREATED, accessToken);
    }
}
