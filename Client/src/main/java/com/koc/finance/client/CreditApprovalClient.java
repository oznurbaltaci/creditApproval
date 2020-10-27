package com.koc.finance.client;

import com.koc.finance.configuration.FeignClientConfiguration;
import com.koc.finance.model.request.CreditApprovalRequest;
import com.koc.finance.model.response.CreditApprovalResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "credit-approval-service", configuration = FeignClientConfiguration.class)
public interface CreditApprovalClient {

    @PostMapping(value = "/credit/recourse")
    CreditApprovalResponse getCreditApprovalResponse(@RequestBody CreditApprovalRequest creditApprovalRequest);
}
