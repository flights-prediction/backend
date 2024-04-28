package com.backend.aiplane.domain.user.application.dto;

import lombok.Builder;

@Builder
public record UserRequest(String accessToken) {

}
