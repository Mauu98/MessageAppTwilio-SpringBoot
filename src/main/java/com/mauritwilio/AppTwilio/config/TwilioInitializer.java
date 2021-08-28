package com.mauritwilio.AppTwilio.config;

import com.twilio.Twilio;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TwilioInitializer { //Clase para manejar la conexión con API de Twilio

    private final TwilioConfiguration twilioConfiguration;

    private final static Logger LOG = LoggerFactory.getLogger(TwilioInitializer.class);

    @Autowired
    public TwilioInitializer(TwilioConfiguration twilioConfiguration){ //Inyección de dependencia
        this.twilioConfiguration = twilioConfiguration;
        //Conexión con API de Twilio
        Twilio.init(
                twilioConfiguration.getAccountSid(),
                twilioConfiguration.getAuthToken()
        );
        LOG.info("Twilio se ha inicializado con la cuenta ", twilioConfiguration.getAccountSid());
    }
}
