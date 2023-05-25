package com.example.BusTicket.service;

import com.example.BusTicket.entities.Bus;
import com.example.BusTicket.entities.User;
import com.example.BusTicket.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User>findUsers(){
        return userRepository.findAll();
    }

    public double calaculateTicketsPrice(int id) {
        List<User> ticketPriceById = userRepository.findTicketPriceById(id);

        double v = 0;
        for (User user : ticketPriceById) {
            for (Bus t : user.getBuses()) {
                v = t.getPrice() * t.getOccupiedseats();
            }
        }
        return v;
    }


}
