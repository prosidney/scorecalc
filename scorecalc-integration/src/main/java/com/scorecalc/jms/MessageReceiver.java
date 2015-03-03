package com.scorecalc.jms;

import com.scorecalc.model.Input;
import com.scorecalc.service.JmsProcessorService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.jms.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by Sidney on 15-03-02.
 */
public class MessageReceiver implements MessageListener {

    @Autowired
    private JmsProcessorService jmsProcessorService;

    public void onMessage(final Message message) {
        jmsProcessorService.process(message);
    }
}
