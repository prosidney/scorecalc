package com.scorecalc.service;

import com.scorecalc.model.Input;
import org.springframework.stereotype.Service;

import javax.jms.JMSException;
import javax.jms.MapMessage;
import javax.jms.Message;
import javax.jms.ObjectMessage;
import java.util.List;

/**
 * Created by Sidney on 15-03-03.
 */
@Service
public class JmsProcessorService {

    public void process(Message message){
        System.out.println("======Start=======");
        try {
            Thread.sleep(4000);

            if (message instanceof MapMessage) {
                final MapMessage mapMessage = (MapMessage) message;
                String id = (String) mapMessage.getObject("id");
                List<String> texts = (List<String>) mapMessage.getObject("texts");

                System.out.println(id + "," +texts);
            } else if (message instanceof ObjectMessage) {
                ObjectMessage objMessage = (ObjectMessage) message;

                Input object = (Input) objMessage.getObject();

                System.out.println(object);
            }

        } catch (JMSException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("======END========");
    }
}
