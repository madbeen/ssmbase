package com.jackson.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TargetController {

    @RequestMapping(value = "/target")
    public ModelAndView show() {
        System.out.println("目標資源執行....");

        ModelAndView modelAndView = new ModelAndView();

        modelAndView.addObject("name", "jackson");

        modelAndView.setViewName("success");

        return modelAndView;
    }


}
