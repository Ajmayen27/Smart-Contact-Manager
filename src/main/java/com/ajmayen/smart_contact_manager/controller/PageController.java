package com.ajmayen.smart_contact_manager.controller;

import com.ajmayen.smart_contact_manager.forms.UserForms;
import com.ajmayen.smart_contact_manager.model.User;
import com.ajmayen.smart_contact_manager.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class PageController {

    @Autowired
    private UserService userService;

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



   @RequestMapping(value = "/do-register",method = RequestMethod.POST)
   public String processRegister(@ModelAttribute UserForms userForms){
        System.out.println("Registration Done");
        //fetch form data
        System.out.println(userForms);
       //validate form data
       //save to database
//        User user = User.builder()
//                        .name(userForms.getName())
//                        .email(userForms.getEmail())
//                        .password(userForms.getPassword())
//                        .about(userForms.getAbout())
//                        .phone(userForms.getPhoneNumber())
//                        .profilePic("https://upload.wikimedia.org/wikipedia/commons/a/ac/Default_pfp.jpg")
//                        .build();
       User user = new User();
       user.setName(userForms.getName());
       user.setEmail(userForms.getEmail());
       user.setPassword(userForms.getPassword());
       user.setPhone(userForms.getPhoneNumber());
       user.setAbout(userForms.getAbout());
       user.setProfilePic("https://upload.wikimedia.org/wikipedia/commons/a/ac/Default_pfp.jpg");

        User savedUser = userService.saveUser(user);
       System.out.println("Saved User: " + savedUser);




       //message=registration successful
       //redirect to login page
      return "redirect:/register";
    }


}
