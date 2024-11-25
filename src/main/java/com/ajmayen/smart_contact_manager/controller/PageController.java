package com.ajmayen.smart_contact_manager.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {

    @RequestMapping("/home")
    public String home(Model model){
        System.out.println("Home Page");
        model.addAttribute("name","About Ajmayen Fayek");
        model.addAttribute("YoutubeChannel","Ajmayen Fayek");
        model.addAttribute("github","https://github.com/ajmayen");
        return "home";
    }

    @RequestMapping("/about")
    public String about(Model model){
        System.out.println("About page");
        model.addAttribute("isLoggedIn",true);
        return "about";
    }

    @RequestMapping("/services")
    public String services(){
        System.out.println("services loading");
        return "services";
    }

}
