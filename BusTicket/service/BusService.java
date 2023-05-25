package com.example.BusTicket.service;

import com.example.BusTicket.entities.Bus;
import com.example.BusTicket.repo.BusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BusService {
    @Autowired
    private BusRepository busRepository;

    public List<Bus> findAllBuses() {
        return busRepository.findAll();
    }

    public double findTicketPriceTotal(int busId) {
        var priceList = busRepository.findPriceByBusId(busId);
        var seatsList = busRepository.findOccupiedseatsByBusId(busId);
        double totalprice = 0;
        for (Bus bus : priceList) {

            for (Bus bus1 : seatsList) {
                totalprice = bus.getPrice() * bus1.getOccupiedseats();
            }
        }
        return totalprice;
    }


    public List<Bus> findOriginsMultipleBuses(int busId) {
        return busRepository.findOriginAndDestinationByBusId(busId);
    }

    public List<Bus> findbuses(String origin, String destination) {
        List<Bus> bus = busRepository.findByOriginAndDestination(origin, destination);
        List<Bus> busseslist = new ArrayList<>();
        for (Bus b : bus) {
            if (b.getOrigin().equals(origin) && b.getDestination().equals(destination)) {
                busseslist.add(b);
            }
        }
        return busseslist;
    }

    public double totalPrice() {
        List<Bus> buses = busRepository.findAll();
        double totalprice = 0;
        for(Bus b : buses){
            var price = b.getPrice()*b.getOccupiedseats();
            totalprice=totalprice+price;
        }
        return totalprice;
    }



}




