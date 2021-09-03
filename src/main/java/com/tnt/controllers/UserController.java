/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tnt.controllers;

import com.tnt.pojos.User;
import com.tnt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author truongtn
 */
@Controller
public class UserController {
    @Autowired
    private UserService userDetailService;
    
    @GetMapping("/login")
    public String login(){
        return "login";
    }
    
    @GetMapping("/register")
    public String registerView(Model model){
        model.addAttribute("user", new User());
        return "register";
    }
    
    @PostMapping("/register")
    public String register(Model model, @ModelAttribute(value = "user") User user){
        String errorMsg = "";
        if(user.getPassword().equals(user.getConfirmPassword())){
            if(this.userDetailService.addUser(user)){
                return "redirect:/login";
            }else{
                errorMsg = "Occured error. Please try again!!";
            }
        }else{
            errorMsg = "Retype password is wrong";
        }
        model.addAttribute("errMsg", errorMsg);
        
        return "register";
    }
}
