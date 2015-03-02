package com.scorecalc.controller;

import com.scorecalc.jms.MessageSender;
import com.scorecalc.model.Input;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

/**
 * Created by Sidney on 15-03-02.
 */
@RestController
public class InputController {

    @Autowired
    MessageSender messageSender;

    @RequestMapping(value = "/input", method = RequestMethod.POST)
    public String printWelcome(@RequestBody Input request) {
        HashMap<Object, Object> map = new HashMap<>();

        map.put("Name", "MYNAME");
        map.put("id", request.getId());

        messageSender.send(map);
        return "input " + request.getId() + " received with sucess.";
    }
}
