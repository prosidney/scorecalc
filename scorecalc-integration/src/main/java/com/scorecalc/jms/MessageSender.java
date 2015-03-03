package com.scorecalc.jms;

import com.scorecalc.model.Input;
import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;

import javax.jms.*;
import java.util.Map;

/**
 * Created by Sidney on 15-03-02.
 */
public class MessageSender {

    private final JmsTemplate jmsTemplate;

    @Autowired
    private ActiveMQQueue defaultDestination;

    public MessageSender(final JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }

    public void send(final Map map) {
        jmsTemplate.convertAndSend(map);
    }

    public void send1(final Input request){
        jmsTemplate.send("queueName", new MessageCreator() {

            @Override
            public Message createMessage(Session session) throws JMSException {
                MessageProducer producer = session.createProducer(defaultDestination);

                ObjectMessage message = session.createObjectMessage(request);

                producer.send(message);

                return message;
            }
        });
    }

}
