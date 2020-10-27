package com.koc.finance.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCode {

    GENERAL_EXCEPTION(1000, "Sistemde bir hata olustu."),
    ARGUMENT_NOT_VALID(1001, "Zorunlu parametreler bos olamaz");

    private int code;
    private String message;
}
