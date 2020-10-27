package com.koc.finance.service;

import com.koc.finance.client.CreditApprovalClient;
import com.koc.finance.model.request.CreditApprovalRequest;
import com.koc.finance.model.response.CreditApprovalResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreditApprovalService {
    private final CreditApprovalClient creditApprovalClient;

    public CreditApprovalResponse getCreditApprovalResponse(CreditApprovalRequest creditApprovalRequest){
        return creditApprovalClient.getCreditApprovalResponse(creditApprovalRequest);
    }
}
