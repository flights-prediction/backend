package com.backend.aiplane.global.exception;

import com.backend.aiplane.global.response.ErrorCode;
import lombok.Getter;

@Getter
//@RequiredArgsConstructor
public class GlobalException extends RuntimeException {

    private final ErrorCode errorCode;

    public GlobalException(ErrorCode errorCode) {
        super(errorCode.getMessage());
        this.errorCode = errorCode;
    }
}
