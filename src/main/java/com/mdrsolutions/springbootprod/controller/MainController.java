package com.mdrsolutions.springbootprod.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.core.env.Environment;

@Controller
public class MainController {

    @Autowired
    private Environment env;

    @Value("${logo.title}")
    private String logoTitle;

    @Value("${welcome.message}")
    private String welcomeMessage;

    @GetMapping({"/", "/index"})
    public String welcomePage(Model model){
        System.out.println(env.getActiveProfiles().length);
        model.addAttribute("logoTitle", logoTitle);
        model.addAttribute("environments",env.getActiveProfiles());
        model.addAttribute("welcomeMsg", welcomeMessage);

        return "index";
    }

}
