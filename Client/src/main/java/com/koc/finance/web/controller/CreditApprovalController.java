package com.koc.finance.web.controller;

import com.koc.finance.model.request.CreditApprovalRequest;
import com.koc.finance.model.request.CreditApprovalSmsRequest;
import com.koc.finance.model.response.CreditApprovalResponse;
import com.koc.finance.service.CreditApprovalService;
import com.koc.finance.service.SmsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/client")
public class CreditApprovalController {

    private final CreditApprovalService creditApprovalService;
    private final SmsService smsService;

    @PostMapping(value = "/recourse")
    public CreditApprovalResponse getCreditApprovalResponse(@Valid @RequestBody CreditApprovalRequest creditApprovalRequest){
        CreditApprovalResponse creditApprovalResponse = creditApprovalService.getCreditApprovalResponse(creditApprovalRequest);

        CreditApprovalSmsRequest creditApprovalSmsRequest  = new CreditApprovalSmsRequest(creditApprovalResponse,creditApprovalRequest.getPhoneNumber());
        smsService.creditApprovalSms(creditApprovalSmsRequest);

        return creditApprovalResponse;
    }
}
