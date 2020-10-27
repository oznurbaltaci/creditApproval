package com.koc.finance.web.controller;

import com.koc.finance.model.request.CreditApprovalSmsRequest;
import com.koc.finance.service.SmsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/sms")
public class CreditApprovalController {

    private final SmsService smsService;

    @PostMapping(value = "/send")
    @ResponseStatus(HttpStatus.CREATED)
    public void creditApprovalSms(@Valid @RequestBody CreditApprovalSmsRequest creditApprovalSmsRequest){
        smsService.sendSMS(creditApprovalSmsRequest);
    }
}
