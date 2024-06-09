package com.backend.aiplane.domain.like.presentation.dto.request;

public record CreateLikeRequest(
        Long userId,
        Long flightInfoId
) {
}
