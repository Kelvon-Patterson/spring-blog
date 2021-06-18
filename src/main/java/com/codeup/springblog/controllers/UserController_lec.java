package com.codeup.springblog.controllers;

import com.codeup.springblog.models.User_lec;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

//@Controller
//public class UserController_lec {
//
//    @GetMapping("/users/all")
//    public String getAllUsers(
//            Model model
//    ){
//        List<User_lec> listOfUsers = new ArrayList<>();
//
//        listOfUsers.add(new User_lec("Samuel","Moore"));
//        listOfUsers.add(new User_lec("Andrew","Walsh"));
//        listOfUsers.add(new User_lec("Emmanuel","Stephen"));
//        listOfUsers.add(new User_lec("Kenyon","Luce"));
//
//        model.addAttribute("users",listOfUsers);
//
//        return "users";
//    }
//
//    @GetMapping("/user")
//    public String getTheStringUser(
//            Model model
//    ){
//        model.addAttribute("user",new User_lec("Sam","Hirsh"));
//        return "users";
//    }
//
//}