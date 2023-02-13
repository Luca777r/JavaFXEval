package com.evaluation.evalJavaFx.controllers;

import com.evaluation.evalJavaFx.dtos.LocalUserDTO;
import com.evaluation.evalJavaFx.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PublicController {

    UserService userService;
    public PublicController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String homePage() {
        return "home";
    }

    @GetMapping("/new")
    public ModelAndView form() {
        LocalUserDTO userForm = new LocalUserDTO("","");
        ModelAndView mav = new ModelAndView("userForm");
        mav.addObject("userForm", userForm);

        return mav;
    }

    @PostMapping("/new")
    public ModelAndView addUser(@ModelAttribute LocalUserDTO localUserDTO) {

        userService.addUser(localUserDTO);
        return new ModelAndView("redirect:/");
    }
}
