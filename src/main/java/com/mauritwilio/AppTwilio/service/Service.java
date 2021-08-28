package com.mauritwilio.AppTwilio.service;

import com.mauritwilio.AppTwilio.sms.SmsRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

@org.springframework.stereotype.Service
public class Service{

    private final TwilioSmsSenderService smsSender;

    @Autowired
    public Service(@Qualifier("twilio") TwilioSmsSenderService smsSender) {
        this.smsSender = smsSender;
    }

    public void smsSender(SmsRequest smsRequest){
        smsSender.sendSms(smsRequest);
    }


}
