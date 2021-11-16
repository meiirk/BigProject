import java.io.Serializable;
import java.util.ArrayList;

public class PackageData implements  Serializable {
    String operationType;

    ArrayList<Aircrafts> aircrafts;

    Aircrafts   aircraft;
    ArrayList<Flights> flights;
    Flights   flight;
    ArrayList<Cities> cities;
    Cities   city;
    Tickets   ticket;
    ArrayList<Tickets> tickets;

    public void setTickets(ArrayList<Tickets> tickets) {
        this.tickets = tickets;
    }

    public void setTicket(Tickets ticket) {
        this.ticket = ticket;
    }

    public ArrayList<Tickets> getTickets() {
        return tickets;
    }

    public Tickets getTicket() {
        return ticket;
    }

    public void setAircraft(Aircrafts aircraft) {
        this.aircraft = aircraft;
    }

    public void setAircrafts(ArrayList<Aircrafts> aircrafts) {
        this.aircrafts = aircrafts;
    }

    public void setOperationType(String operationType) {
        this.operationType = operationType;
    }

    public void setFlights(ArrayList<Flights> flights) {
        this.flights = flights;
    }

    public void setFlight(Flights flight) {
        this.flight = flight;
    }

    public void setCities(ArrayList<Cities> cities) {
        this.cities = cities;
    }

    public void setCity(Cities city) {
        this.city = city;
    }

    public Aircrafts getAircraft() {
        return aircraft;
    }

    public ArrayList<Aircrafts> getAircrafts() {
        return aircrafts;
    }

    public ArrayList<Flights> getFlights() {
        return flights;
    }

    public String getOperationType() {
        return operationType;
    }

    public Flights getFlight() {
        return flight;
    }

    public Cities getCity() {
        return city;
    }

    public ArrayList<Cities> getCities() {
        return cities;
    }

    @Override
    public String toString() {
        return "PackageData{" +
                "operationType='" + operationType + '\'' +
                ", aircrafts=" + aircrafts +
                ", aircraft=" + aircraft +
                ", flights=" + flights +
                ", flight=" + flight +
                ", cities=" + cities +
                ", city=" + city +
                ", ticket=" + ticket +
                ", tickets=" + tickets +
                '}';
    }
}
