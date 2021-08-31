/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tnt.controllers;

import com.tnt.pojos.User;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.persistence.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author truongtn
 */
@Controller
public class HomeController {
//    @RequestMapping("/")
//    public String index(Model model, 
//            @RequestParam(value = "first_name", required = false, defaultValue = "Than") String firstName, 
//            @RequestParam(value = "last_name", required = false, defaultValue = "TruongTN") String lastName){
//        if(firstName != null && lastName != null){
//            model.addAttribute("name", String.format("%s %s", firstName, lastName));
//        }else{
//           model.addAttribute("name", "TruongTN"); 
//        }
//        
//        return "index";
//    }

//    @RequestMapping("/")
//    public String index(Model model, 
//            @RequestParam Map<String, String> params){
//        String firstName = params.get("first_name");
//        String lastName = params.get("last_name");
//        if(firstName != null && lastName != null){
//            model.addAttribute("name", String.format("%s %s", firstName, lastName));
//        }else{
//           model.addAttribute("name", "TruongTN"); 
//        }
//        
//        model.addAttribute("user", new User());
//        
//        List<User> users = new ArrayList<>();
//        users.add(new User("Than", "Truong"));
//        users.add(new User("Than", "Su"));
//        
//        model.addAttribute("users", users);
//        
//        return "index";
//    }
    
    @Autowired
    private LocalSessionFactoryBean sessionFactory;

    @RequestMapping("/")
    public String index(Model model) {
        Session session = sessionFactory.getObject().openSession();
        Query q = session.createQuery("From Category");
        model.addAttribute("categories", q.getResultList());
        session.close();
        return "index";
    }

    @RequestMapping("/hello/{name}")
    public String hello(Model model, @PathVariable(value = "name") String name) {
        model.addAttribute("message", "Welcome " + name + "!!!");
        return "hello";
    }

    @RequestMapping(path = "/hello-post", method = RequestMethod.POST)
    public String showHello(Model model,
            @ModelAttribute(value = "user") User user) {
        model.addAttribute("full_name", user.getFirstName() + " " + user.getLastName());

        return "index";
    }

    @RequestMapping(path = "/test")
    public String testRedirect(Model model) {
        model.addAttribute("testMsg", "WELCOME REDIRECT!!!");

        return "redirect:/hello/Truong";
    }
}
