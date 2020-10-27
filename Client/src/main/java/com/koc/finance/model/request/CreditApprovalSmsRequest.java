package com.koc.finance.model.request;

import com.koc.finance.model.response.CreditApprovalResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreditApprovalSmsRequest {
    private Integer status;
    private String message;
    private Integer creditAmount;
    private String phoneNumber;
    public CreditApprovalSmsRequest(CreditApprovalResponse creditApprovalResponse, String phoneNumber){
        this.status = creditApprovalResponse.getStatus();
        this.message = creditApprovalResponse.getMessage();
        this.creditAmount = creditApprovalResponse.getCreditAmount();
        this.phoneNumber = phoneNumber;

    }
}
