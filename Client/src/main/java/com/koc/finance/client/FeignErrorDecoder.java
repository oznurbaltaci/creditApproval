package com.koc.finance.client;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.koc.finance.exception.CommonServiceException;
import com.koc.finance.exception.ErrorCode;
import com.koc.finance.web.advice.ErrorResponse;
import feign.Response;
import feign.Util;
import feign.codec.ErrorDecoder;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class FeignErrorDecoder implements ErrorDecoder {

    private final ObjectMapper objectMapper;

    @Override
    public Exception decode(String s, Response response) {
        String content = "";
        try {
            content = Util.toString(response.body().asReader());
            final ErrorResponse errorResponse = objectMapper.readValue(content, ErrorResponse.class);
            return new CommonServiceException(errorResponse);
        } catch (Exception e) {
            log.error("Status code {}, content = {}", response.status(), content);
            throw new CommonServiceException(ErrorCode.GENERAL_EXCEPTION);
        }
    }
}
