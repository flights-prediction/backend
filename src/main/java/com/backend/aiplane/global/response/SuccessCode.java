package com.backend.aiplane.global.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@Getter
public enum SuccessCode {
    /**
     * 200 OK
     */
    OK(200,HttpStatus.OK, "요청이 성공했습니다."),

    /**
     * 201 CREATED SUCCESS
     */
    CREATED(201, HttpStatus.CREATED, "생성 요청이 성공했습니다."),
    USER_CREATED(201, HttpStatus.CREATED, "유저 회원가입이 성공했습니다."),
    TOKEN_CREATED(201, HttpStatus.CREATED, "토큰 생성에 성공했습니다.");

    private final int statusCode;
    private final HttpStatus status;
    private final String message;

}