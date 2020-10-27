package com.koc.finance.web.controller;

import com.koc.finance.model.request.CreditApprovalRequest;
import com.koc.finance.model.response.CreditApprovalResponse;
import com.koc.finance.service.CreditApprovalService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/credit")
public class CreditApprovalController {

    private final CreditApprovalService creditApprovalService;

    @PostMapping(value = "/recourse")
    @ResponseStatus(HttpStatus.CREATED)
    public CreditApprovalResponse getCreditApprovalResponse(@Valid @RequestBody CreditApprovalRequest creditApprovalRequest){
        return creditApprovalService.getCreditApprovalResponse(creditApprovalRequest);
    }
}
