package com.example.BusTicket.controller;

import com.example.BusTicket.entities.Bus;
import com.example.BusTicket.service.BusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BusController {
    @Autowired
    private BusService busService;

    @GetMapping("/bus")
    public List<Bus>busesList(){

        return busService.findAllBuses();
    }

    @GetMapping("/price/{busId}")
    public double busprices(@PathVariable("busId")int busId){
        return  busService.findTicketPriceTotal(busId);
    }
    @GetMapping("/origin/{busId}")
    public List<Bus> getOriginsMultipleBuses(@PathVariable("busId")int busId) {
        return busService.findOriginsMultipleBuses(busId);
    }

    @GetMapping("/buslist/{origin}/{destination}")
    public List<Bus> busseslist(@PathVariable("origin")String origin, @PathVariable("destination")String destination){
        return busService.findbuses(origin,destination);
    }
    @GetMapping("/totalTicketPrice")
    public double TotalTicketPrices(){

       return busService.totalPrice();
    }

}


