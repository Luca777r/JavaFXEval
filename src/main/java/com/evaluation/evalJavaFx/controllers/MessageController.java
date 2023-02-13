package com.evaluation.evalJavaFx.controllers;

import com.evaluation.evalJavaFx.dtos.MessageDTO;
import com.evaluation.evalJavaFx.services.MessageService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping(value = "/private/messages")
public class MessageController {

    @GetMapping("/{username}")
    public ModelAndView getMessages(@PathVariable final String username) {

        List<MessageDTO> messages = MessageService.getMessagesByName(username);
        ModelAndView mav = new ModelAndView("messages");
        mav.addObject("messages", messages);

        return mav;
    }
}
