package com.koc.finance.exception;

import com.koc.finance.web.advice.ErrorResponse;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;

@Getter
@Setter
public class CommonServiceException extends RuntimeException {

    private Integer code;
    private String message;

    @Value("${spring.application.name}")
    private String serviceName;
    private Object extras;

    public CommonServiceException(ErrorCode errorCode) {
        super();
        this.code = errorCode.getCode();
        this.message = errorCode.getMessage();
    }

    public CommonServiceException(ErrorCode errorCode, Object objects) {
        super();
        this.code = errorCode.getCode();
        this.message = errorCode.getMessage();
        this.extras = objects;
    }

    public CommonServiceException(ErrorResponse response) {
        super();
        this.code = response.getCode();
        this.message = response.getMessage();
        this.serviceName = String.format("%s -> %s", serviceName, response.getServiceName());
    }
}
