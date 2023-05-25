package com.example.BusTicket.repo;

import com.example.BusTicket.entities.Bus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BusRepository extends JpaRepository<Bus,Integer> {
 public List<Bus> findPriceByBusId(int busId);

 public List<Bus> findTicketPriceByBusId(int busId);

 public List<Bus> findOccupiedseatsByBusId(int busId);


 List<Bus> findOriginAndDestinationByBusId(int busId);

 List<Bus> findByOriginAndDestination(String origin, String destination);







}