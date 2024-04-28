package com.backend.aiplane.global.exception;

import com.backend.aiplane.global.exception.GlobalException;
import com.backend.aiplane.global.response.ErrorCode;
import lombok.Getter;

@Getter
public class DuplicateUserException extends GlobalException {

    public DuplicateUserException(ErrorCode errorCode) {
        super(errorCode);
    }
}
