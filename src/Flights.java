import java.io.Serializable;

public class Flights   implements Serializable {
     Long id;

    protected int aircraft_id;

    protected int departure_city_id;

    protected int arrival_city_id;

    protected String departure_time;

    protected int econom_place_price;

    protected int business_place_price;

  public Flights(Long id,int aircraft_id,int departure_city_id,int arrival_city_id,String departure_time,int econom_place_price,int business_place_price){
      this.id=id;
      this.aircraft_id=aircraft_id;
      this.departure_time=departure_time;
      this.departure_city_id=departure_city_id;
      this.arrival_city_id=arrival_city_id;
      this.econom_place_price=econom_place_price;
      this.business_place_price=business_place_price;

  }
     public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setArrival_city_id(int arrival_city_id) {
        this.arrival_city_id = arrival_city_id;
    }

    public void setDeparture_city_id(int departure_city_id) {
        this.departure_city_id = departure_city_id;
    }

    public void setDeparture_time(String departure_time) {
        this.departure_time = departure_time;
    }

    public void setEconom_place_price(int econom_place_price) {
        this.econom_place_price = econom_place_price;
    }

    public int getAircraft_id() {
        return aircraft_id;
    }

    public int getArrival_city_id() {
        return arrival_city_id;
    }

    public int getBusiness_place_price() {
        return business_place_price;
    }

    public int getDeparture_city_id() {
        return departure_city_id;
    }

    public int getEconom_place_price() {
        return econom_place_price;
    }

    public String getDeparture_time() {
        return departure_time;
    }

    public void setBusiness_place_price(int business_place_price) {
        this.business_place_price = business_place_price;
    }

    public void setAircraft_id(int aircraft_id) {
        this.aircraft_id = aircraft_id;
    }

    @Override
    public String toString() {
        return id + ") " + aircraft_id + " " + departure_city_id + " " + arrival_city_id +
                " " + departure_time +
                " " + econom_place_price +
                " " + business_place_price;
    }
}
