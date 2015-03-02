package com.scorecalc.jms;

import org.springframework.jms.core.JmsTemplate;
import java.util.Map;

/**
 * Created by Sidney on 15-03-02.
 */
public class MessageSender {

    private final JmsTemplate jmsTemplate;

    public MessageSender(final JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }

    public void send(final Map map) {
        jmsTemplate.convertAndSend(map);
    }

}
