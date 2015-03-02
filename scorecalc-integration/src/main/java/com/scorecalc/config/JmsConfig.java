package com.scorecalc.config;

import com.scorecalc.jms.MessageReceiver;
import com.scorecalc.jms.MessageSender;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.jms.connection.CachingConnectionFactory;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.listener.SimpleMessageListenerContainer;

/**
 * Created by Sidney on 15-03-02.
 */
@Configuration
public class JmsConfig {

    String url = "vm://localhost";
    String queueName = "queueName";

    //sending side

    //Activemq connection factory
    @Bean
    public ActiveMQConnectionFactory amqConnectionFactory() {
        return new ActiveMQConnectionFactory(url);
    }

    //ConnectionFactory Definition
    @Bean
    public CachingConnectionFactory connectionFactory() {
        return new CachingConnectionFactory(amqConnectionFactory());
    }

    //Default Destination Queue Definition
    @Bean
    public ActiveMQQueue defaultDestination(){
        return new ActiveMQQueue(queueName);
    }

    //JmsTemplate Definition
    @Bean
    public JmsTemplate jmsTemplate(){
        JmsTemplate jmsTemplate = new JmsTemplate(connectionFactory());
        jmsTemplate.setDefaultDestination(defaultDestination());

        return jmsTemplate;
    }

    //Message Sender Definition
    @Bean
    public MessageSender messageSender(){
        return new MessageSender(jmsTemplate());
    }


    //receiving side
    @Bean
    public MessageReceiver messageReceiver(){
        return new MessageReceiver();
    }

    //Message Sender Definition
    @Bean
    public SimpleMessageListenerContainer simpleMessageListenerContainer(){
        SimpleMessageListenerContainer smlc = new SimpleMessageListenerContainer();

        smlc.setConnectionFactory(connectionFactory());
        smlc.setDestinationName(queueName);
        smlc.setMessageListener(messageReceiver());
        //smlc.setConcurrency("3-5");

        return smlc;
    }

}
