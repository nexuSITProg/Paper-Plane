package db;

import java.sql.Time;

public class Path {
    private int pathId;
    private int pathNumber;
    private String departureAirport;
    private String destinationAirport;
    private int ticketPrice;
    private Time flightTime;

    public int getPathId() {
        return pathId;
    }

    public void setPathId(int pathId) {
        this.pathId = pathId;
    }

    public int getPathNumber() {
        return pathNumber;
    }

    public void setPathNumber(int pathNumber) {
        this.pathNumber = pathNumber;
    }

    public String getDepartureAirport() {
        return departureAirport;
    }

    public void setDepartureAirport(String departureAirport) {
        this.departureAirport = departureAirport;
    }

    public String getDestinationAirport() {
        return destinationAirport;
    }

    public void setDestinationAirport(String destinationAirport) {
        this.destinationAirport = destinationAirport;
    }

    public int getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(int ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    public Time getFlightTime() {
        return flightTime;
    }

    public void setFlightTime(Time flightTime) {
        this.flightTime = flightTime;
    }

    @Override
    public String toString() {
        return "Path " + pathId + " {" + "\n" +
                "path number: " + pathNumber + "\n" +
                "departure airport: " + departureAirport + "\n" +
                "destination airport: " + destinationAirport + "\n" +
                "ticket price: " + ticketPrice + "\n" +
                "flight time: " + flightTime + "\n}";
    }
}
