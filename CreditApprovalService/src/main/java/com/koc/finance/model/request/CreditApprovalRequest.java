package com.koc.finance.model.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreditApprovalRequest {

    @NotNull
    private Long identityNumber;
    @NotBlank
    private String name;
    @NotBlank
    private String surname;
    @NotNull
    private Integer monthlyIncome;
    @NotBlank
    private String phoneNumber;

}
