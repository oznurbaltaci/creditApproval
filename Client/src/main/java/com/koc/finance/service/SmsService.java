package com.koc.finance.service;

import com.koc.finance.client.CreditApprovalClient;
import com.koc.finance.client.SmsClient;
import com.koc.finance.model.request.CreditApprovalRequest;
import com.koc.finance.model.request.CreditApprovalSmsRequest;
import com.koc.finance.model.response.CreditApprovalResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SmsService {
    private final SmsClient smsClient;

    public void creditApprovalSms(CreditApprovalSmsRequest creditApprovalSmsRequest){
        smsClient.creditApprovalSms(creditApprovalSmsRequest);
    }
}
