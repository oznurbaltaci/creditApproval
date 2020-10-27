package com.koc.finance.client;

import com.koc.finance.configuration.FeignClientConfiguration;
import com.koc.finance.model.request.CreditApprovalRequest;
import com.koc.finance.model.request.CreditApprovalSmsRequest;
import com.koc.finance.model.response.CreditApprovalResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;


@FeignClient(name = "notification-service", configuration = FeignClientConfiguration.class)
public interface SmsClient {

    @PostMapping(value = "/sms/send")
    void creditApprovalSms(@RequestBody CreditApprovalSmsRequest creditApprovalSmsRequest);

}
