package com.example.BusTicket.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "bus")
public class Bus {
    @Id
    @GeneratedValue
    @Column(name = "bus_id")
    private int busId;

    @Column(name="origin")
    private String origin;

    @Column(name = "destination")
    private String destination;

    @Column(name = "price")
    private double price;

    @Column(name = "occupiedseats")
    private int occupiedseats;

    @Column(name = "availableseats")
    private int availableseats;

    @Column(name = "pendingseats")
    private int pendingseats;

    @ManyToOne
    @JoinColumn(name = "id")
    @JsonIgnore
    private User user;

    public Bus(int busId, String origin, String destination, double price, int occupiedseats, int availableseats, int pendingseats, User user) {
        this.busId = busId;
        this.origin = origin;
        this.destination = destination;
        this.price = price;
        this.occupiedseats = occupiedseats;
        this.availableseats = availableseats;
        this.pendingseats = pendingseats;
        this.user = user;
    }

    public Bus() {
    }

    public int getBusId() {
        return busId;
    }

    public void setBusId(int busId) {
        this.busId = busId;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getOccupiedseats() {
        return occupiedseats;
    }

    public void setOccupiedseats(int occupiedseats) {
        this.occupiedseats = occupiedseats;
    }

    public int getAvailableseats() {
        return availableseats;
    }

    public void setAvailableseats(int availableseats) {
        this.availableseats = availableseats;
    }

    public int getPendingseats() {
        return pendingseats;
    }

    public void setPendingseats(int pendingseats) {
        this.pendingseats = pendingseats;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Bus bus)) return false;
        return busId == bus.busId && Double.compare(bus.price, price) == 0 && occupiedseats == bus.occupiedseats && availableseats == bus.availableseats && pendingseats == bus.pendingseats && Objects.equals(origin, bus.origin) && Objects.equals(destination, bus.destination) && Objects.equals(user, bus.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(busId, origin, destination, price, occupiedseats, availableseats, pendingseats, user);
    }

    @Override
    public String toString() {
        return "Bus{" +
                "busId=" + busId +
                ", origin='" + origin + '\'' +
                ", destination='" + destination + '\'' +
                ", price=" + price +
                ", occupiedseats=" + occupiedseats +
                ", availableseats=" + availableseats +
                ", pendingseats=" + pendingseats +
                ", user=" + user +
                '}';
    }
}
