/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tnt.controllers;

import com.tnt.pojos.User;
import com.tnt.service.CategoryService;
import com.tnt.service.ProductService;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
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
@ControllerAdvice
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
    private CategoryService categoryService;

    @Autowired
    private ProductService productService;

    @ModelAttribute
    public void commonAttr(Model model){
        model.addAttribute("categories", this.categoryService.getCategories());
    }
    
    @RequestMapping("/")
    public String index(Model model, @RequestParam(required = false) Map<String, String> params) {
        int page = Integer.parseInt(params.getOrDefault("page", "1"));
        model.addAttribute("products", this.productService.getProducts(params.get("searchValue"), page));
        model.addAttribute("counter", this.productService.countProduct());
        //if tiles.xml has baselayout -> return page
        //if tiles.xml has no baselayout -> find in InternalResourceViewResolver -> return page
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

    @RequestMapping(path = "/cart")
    public String cart(Model model) {
        return "cart";
    }
}
