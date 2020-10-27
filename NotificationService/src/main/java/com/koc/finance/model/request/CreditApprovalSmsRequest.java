package com.koc.finance.model.request;

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
}
