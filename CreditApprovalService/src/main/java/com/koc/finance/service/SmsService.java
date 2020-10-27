package com.koc.finance.service;

import com.koc.finance.model.response.CreditApprovalResponse;
import com.koc.finance.properties.CommonConstants;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class SmsService {
    @Value("${twilio.SID}")
    private String ACCOUNT_SID;
    @Value("${twilio.auth_token}")
    private String AUTH_TOKEN;
    @Value("${twilio.number}")
    private String TWILIO_NUMBER;

    public void sendSMS(CreditApprovalResponse creditApprovalResponse, String phoneNumber){
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
        String messageText = creditApprovalResponse.getStatus() == CommonConstants.SUCCESS ?
                creditApprovalResponse.getMessage()+"\n Kredi miktarı: "+creditApprovalResponse.getCreditAmount()
                : creditApprovalResponse.getMessage();
        Message message = Message.creator(
                new PhoneNumber(phoneNumber),
                new PhoneNumber(TWILIO_NUMBER),
                messageText)
                .create();
    }
}
