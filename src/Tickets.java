import java.io.Serializable;

public class Tickets extends Cashier implements Serializable {
    protected Long id;
    protected int flight_id;
    protected String name;
    protected String surname;
    protected String passport_number;
    protected String ticket_type;
  public Tickets(Long id,int flight_id,String name,String surname,String passport_number,String ticket_type){
      this.id=id;
      this.flight_id=flight_id;
      this.name=name;
      this.surname=surname;
      this.passport_number=passport_number;
      this.ticket_type=ticket_type;

  }

    public String getSurname() {
        return surname;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getTicket_type() {
        return ticket_type;
    }

    public String getPassport_number() {
        return passport_number;
    }

    public int getFlight_id() {
        return flight_id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setFlight_id(int flight_id) {
        this.flight_id = flight_id;
    }

    public void setPassport_number(String passport_number) {
        this.passport_number = passport_number;
    }

    public void setTicket_type(String ticket_type) {
        this.ticket_type = ticket_type;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Override
    public String toString() {
        return id + ") " + flight_id + " " + name + " " + surname + " " + passport_number + " " + ticket_type;

    }
}
