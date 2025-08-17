package com.shopperx.shopperxapi.controllers;


import com.shopperx.shopperxapi.entities.User;
import com.shopperx.shopperxapi.services.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/account")
public class UserController {
    @PostMapping ("")
    public String register(User user){
        return "Virtue";
    }
}
