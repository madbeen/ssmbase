package com.jackson.controller;


import com.jackson.exception.MyException;
import com.jackson.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DemoController {

    @Autowired
    private DemoService demoService;

    @RequestMapping(value = "/show")
    public String show(@RequestParam(value = "name", required = false) String name) throws MyException {

//        demoService.castExp();
//        demoService.divide0Exp();
//        demoService.fileNotFoundExp();
//        demoService.npExp();
        demoService.customExp();


        return "index";
    }


}
