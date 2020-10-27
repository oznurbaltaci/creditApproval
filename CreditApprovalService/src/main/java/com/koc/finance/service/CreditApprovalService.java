package com.koc.finance.service;

import com.koc.finance.exception.CommonServiceException;
import com.koc.finance.exception.ErrorCode;
import com.koc.finance.model.request.CreditApprovalRequest;
import com.koc.finance.model.response.CreditApprovalResponse;
import com.koc.finance.persistence.entity.CreditRecourseEntity;
import com.koc.finance.persistence.repository.CreditRecourseRepository;
import com.koc.finance.properties.CommonConstants;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@RequiredArgsConstructor
public class CreditApprovalService {

    private final CreditRecourseRepository creditRecourseRepository;
    private final CreditPointService creditPointService;
    private final SmsService smsService;

    public CreditApprovalResponse getCreditApprovalResponse(CreditApprovalRequest creditApprovalRequest){
        checkByIdentityNumber(creditApprovalRequest.getIdentityNumber());
        CreditApprovalResponse creditApprovalResponse;
        switch (checkCreditScoreAndIncome(creditPointService.getCreditPoint(), creditApprovalRequest.getMonthlyIncome())){
            case 1:
                creditApprovalResponse = CreditApprovalResponse.
                        builder()
                        .creditAmount(CommonConstants.MIN_CREDIT_VALUE)
                        .message(CommonConstants.SUCCESS_TEXT)
                        .status(CommonConstants.SUCCESS)
                        .build();
                break;
            case 2:
                creditApprovalResponse = CreditApprovalResponse.
                        builder()
                        .creditAmount(creditApprovalRequest.getMonthlyIncome() * CommonConstants.CREDIT_MULTIPLIER_HALF)
                        .message(CommonConstants.SUCCESS_TEXT)
                        .status(CommonConstants.SUCCESS)
                        .build();
                break;
            case 3:
                creditApprovalResponse = CreditApprovalResponse.
                        builder()
                        .creditAmount(creditApprovalRequest.getMonthlyIncome() * CommonConstants.CREDIT_MULTIPLIER)
                        .message(CommonConstants.SUCCESS_TEXT)
                        .status(CommonConstants.SUCCESS)
                        .build();
                break;
            default:
                creditApprovalResponse = CreditApprovalResponse
                        .builder()
                        .message(CommonConstants.FAILED_TEXT)
                        .status(CommonConstants.FAILED)
                        .build();
                break;
        }

        CreditRecourseEntity creditRecourseEntity = fromCreditApprovalRequest(creditApprovalRequest);
        creditRecourseEntity.setCreditStatus(creditApprovalResponse.getStatus());
        creditRecourseEntity.setCreditAmount(creditApprovalResponse.getCreditAmount());

        creditRecourseRepository.save(creditRecourseEntity);
        //smsService.sendSMS(creditApprovalResponse, creditApprovalRequest.getPhoneNumber());
        return creditApprovalResponse;
    }

    private Integer checkCreditScoreAndIncome(int creditScore, int income){
        if(creditScore > CommonConstants.MIN_CREDIT_SCORE
                && creditScore < CommonConstants.MAX_CREDIT_SCORE
                && income >= CommonConstants.MONTHLY_INCOME_MIN_LIMIT){
            return income < CommonConstants.MONTHLY_INCOME_MAX_LIMIT ? CommonConstants.INCOME_CREDIT_POINT_RESULT_1 : CommonConstants.INCOME_CREDIT_POINT_RESULT_2;
        }else if(creditScore >= CommonConstants.MAX_CREDIT_SCORE
                && income >= CommonConstants.MONTHLY_INCOME_MIN_LIMIT){
            return CommonConstants.INCOME_CREDIT_POINT_RESULT_3;
        }else{
            return CommonConstants.INCOME_CREDIT_POINT_RESULT_4;
        }
    }

    private CreditRecourseEntity fromCreditApprovalRequest(CreditApprovalRequest creditApprovalRequest){
        return CreditRecourseEntity
                .builder()
                .identityNumber(creditApprovalRequest.getIdentityNumber())
                .name(creditApprovalRequest.getName())
                .surname(creditApprovalRequest.getSurname())
                .monthlyIncome(creditApprovalRequest.getMonthlyIncome())
                .phoneNumber(creditApprovalRequest.getPhoneNumber())
                .createDate(new Date()).build();
    }

    private void checkByIdentityNumber(Long identityNumber){
        if(creditRecourseRepository.findByIdentityNumber(identityNumber).isPresent())
            throw new CommonServiceException(ErrorCode.ALREADY_RECOURSED);
    }

}
