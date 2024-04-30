package com.backend.aiplane.domain.user.application;

import com.backend.aiplane.domain.token.domain.RefreshTokenRepository;
import com.backend.aiplane.domain.user.application.dto.UserRequest;
import com.backend.aiplane.domain.user.application.dto.UserResponse;
import com.backend.aiplane.domain.user.domain.User;
import com.backend.aiplane.domain.user.domain.UserRepository;
import com.backend.aiplane.global.util.JwtUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserService {
    private final UserRepository userRepository;
    private final RefreshTokenRepository refreshTokenRepository;
    private final JwtUtil jwtUtil;

    public UserResponse getMyselfInfoByAccessToken(String authorizationHeader) {
        String accessToken = jwtUtil.getTokenFromHeader(authorizationHeader);
        String userId = jwtUtil.getUserIdFromToken(accessToken);
        boolean tokenExpired = jwtUtil.isTokenExpired(accessToken);
        log.info("get userself info token expired :" + tokenExpired);
        log.info("userId or UUID : " + userId);

        User findUser = userRepository.findByUserId(UUID.fromString(userId))
                .orElseThrow(() -> new IllegalArgumentException("no uuid"));

        return UserResponse.builder()
                .name(findUser.getName())
                .build();
    }

}


