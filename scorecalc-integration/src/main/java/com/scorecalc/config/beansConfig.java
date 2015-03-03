package com.scorecalc.config;

import com.scorecalc.jms.MessageReceiver;
import com.scorecalc.service.JmsProcessorService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Sidney on 15-03-03.
 */
@Configuration
public class BeansConfig {

    @Bean
    public JmsProcessorService jmsProcessorService(){
        return new JmsProcessorService();
    }
}
