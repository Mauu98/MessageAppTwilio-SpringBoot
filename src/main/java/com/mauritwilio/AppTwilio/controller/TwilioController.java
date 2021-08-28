package com.mauritwilio.AppTwilio.controller;

import com.mauritwilio.AppTwilio.service.Service;
import com.mauritwilio.AppTwilio.sms.SmsRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/sms")
public class TwilioController {

    private final com.mauritwilio.AppTwilio.service.Service service;

    @Autowired
    public TwilioController(Service service) {
        this.service = service;
    }


    @PostMapping
    public void sendSms(@RequestBody  SmsRequest smsRequest){
        service.smsSender(smsRequest);
    }
}
