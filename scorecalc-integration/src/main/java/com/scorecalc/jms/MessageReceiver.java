package com.scorecalc.jms;

import javax.jms.JMSException;
import javax.jms.MapMessage;
import javax.jms.Message;
import javax.jms.MessageListener;

/**
 * Created by Sidney on 15-03-02.
 */
public class MessageReceiver implements MessageListener {

    public void onMessage(final Message message) {
        System.out.println(message.getClass());
        if (message instanceof MapMessage) {
            final MapMessage mapMessage = (MapMessage) message;


            try {
                Thread.sleep(10000);
                System.out.println(mapMessage.getObject("id"));


            } catch (JMSException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
