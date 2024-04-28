package com.backend.aiplane.domain.user.presentation;

import com.backend.aiplane.domain.user.application.UserService;
import com.backend.aiplane.domain.user.application.dto.UserResponse;
import com.backend.aiplane.global.response.SuccessResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "User API", description = "User API Controller입니다.")
@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @Operation(description = "Access Token을 이용하여 내 정보 조회")
    @GetMapping()
    public ResponseEntity<SuccessResponse<UserResponse>> getMyselfUserInfoByAccessToken(@RequestHeader("Authorization") String authorizationHeader) {
        UserResponse myselfInfoByAccessToken = userService.getMyselfInfoByAccessToken(authorizationHeader);

        return SuccessResponse.of(myselfInfoByAccessToken);
    }
}
