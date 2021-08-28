package com.mauritwilio.AppTwilio.service;

import com.mauritwilio.AppTwilio.config.TwilioConfiguration;
import com.mauritwilio.AppTwilio.sms.SmsRequest;
import com.mauritwilio.AppTwilio.sms.SmsSender;
import com.twilio.rest.api.v2010.account.MessageCreator;
import com.twilio.type.PhoneNumber;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("twilio")
public class TwilioSmsSenderService implements SmsSender {

    private static final Logger LOG = LoggerFactory.getLogger(TwilioSmsSenderService.class);

    private final TwilioConfiguration twilioConfiguration;

    @Autowired
    public TwilioSmsSenderService(TwilioConfiguration twilioConfiguration) {
        this.twilioConfiguration = twilioConfiguration;
    }

    @Override
    public void sendSms(SmsRequest smsRequest) {
        PhoneNumber to = new PhoneNumber(smsRequest.getPhoneNumber());
        PhoneNumber from = new PhoneNumber(twilioConfiguration.getTrialNumber());
        String message = smsRequest.getMessage();
        MessageCreator msg = new MessageCreator(to, from, message);
        msg.create();
        LOG.info("Enviando el siguiente mensaje: ", smsRequest);
    }
}
