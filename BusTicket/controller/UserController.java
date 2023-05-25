package com.example.BusTicket.controller;

import com.example.BusTicket.entities.User;
import com.example.BusTicket.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/user")
    public List<User>find(){
        return  userService.findUsers();
    }

    @GetMapping("/tickets/{id}")
    public double tickets(@PathVariable("id")int id){
        return  userService.calaculateTicketsPrice(id);
    }
}
