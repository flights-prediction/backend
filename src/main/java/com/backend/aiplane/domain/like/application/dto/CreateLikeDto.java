package com.backend.aiplane.domain.like.application.dto;

import lombok.Getter;

@Getter
public class CreateLikeDto {
    Long userId;
    Long flightInfoId;

    public CreateLikeDto(Long userId, Long flightInfoId) {
        this.userId = userId;
        this.flightInfoId = flightInfoId;
    }
}
