package com.example.BusTicket.repo;

import com.example.BusTicket.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User,Integer> {

    public List<User>findTicketPriceById(int id);
}
