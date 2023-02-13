package com.evaluation.evalJavaFx.controllers;

import com.evaluation.evalJavaFx.dtos.CategorieDTO;
import com.evaluation.evalJavaFx.dtos.MessageDTO;
import com.evaluation.evalJavaFx.models.Category;
import com.evaluation.evalJavaFx.repositories.CategoryRepository;
import com.evaluation.evalJavaFx.services.CategorieService;
import com.evaluation.evalJavaFx.services.MessageService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping(value = "/private/profile")
public class ProfileController {

    @GetMapping("")
    public ModelAndView getProfiles() {

        List<Category> categories = CategorieService.getCategories();
        ModelAndView mav = new ModelAndView("categories");
        mav.addObject("categories", categories);

        return mav;
    }
}
