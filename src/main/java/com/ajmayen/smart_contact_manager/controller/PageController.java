package com.ajmayen.smart_contact_manager.controller;

import com.ajmayen.smart_contact_manager.forms.UserForms;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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


    @GetMapping("/contact")
    public String contact(){
        return new String("contact");
    }

    @GetMapping("/login")
    public String login(){
        return new String("login");
    }

    @GetMapping("/register")
    public String register(Model model){
        UserForms userForms = new UserForms();
        model.addAttribute("user",userForms);
        return "register";
    }



   //@RequestMapping(value = "/do-register",method = RequestMethod.POST)
    @PostMapping("/do-register")
    public String processRegister(@ModelAttribute UserForms userForms){
        System.out.println("Registration Done");
        //fetch form data
       System.out.println(userForms);
       //validate form data
       //save to database
       //message=registration successful
       //redirect to login page
      return "redirect:/register";
    }


}
