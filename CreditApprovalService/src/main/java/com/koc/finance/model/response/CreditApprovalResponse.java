package com.koc.finance.model.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreditApprovalResponse {
    private Integer status;
    private String message;
    private Integer creditAmount;
}
