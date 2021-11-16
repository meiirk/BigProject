import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class DBManager {

    Connection connection;

    public void setConnection() {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/bigproject?useUnicode=true&serverTimezone=UTC", "root", "");
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    public void AddCities(Cities city) {
        try {
            PreparedStatement ps = connection.prepareStatement("INSERT INTO cities(id,name,country,short_name)value(null,?,?,?)");
            ps.setString(1, city.getName());
            ps.setString(2, city.getCountry());
            ps.setString(3, city.getShort_name());
            ps.executeUpdate();
            ps.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void AddFlights(Flights flight) {
        try {
            PreparedStatement ps = connection.prepareStatement("INSERT INTO flights(id,aircraft_id,departure_city_id,arrival_city_id,departure_time,econom_place_price,business_place_price)value(null,?,?,?,?,?,?)");
            ps.setInt(1, flight.getAircraft_id());
            ps.setInt(2, flight.getDeparture_city_id());
            ps.setInt(3, flight.getArrival_city_id());
            ps.setString(4, flight.getDeparture_time());
            ps.setInt(5, flight.getEconom_place_price());
            ps.setInt(6, flight.getBusiness_place_price());

            ps.executeUpdate();
            ps.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void AddAircrafts(Aircrafts aircrafts) {

        try {
            PreparedStatement ps = connection.prepareStatement("INSERT INTO aircrafts(id,name,model,business_class_capacity,econom_class_capacity)value(null,?,?,?,?)");
            ps.setString(1, aircrafts.getName());
            ps.setString(2, aircrafts.getModel());
            ps.setInt(3, aircrafts.getBusiness_class_capacity());
            ps.setInt(4, aircrafts.getEconom_class_capacity());


            ps.executeUpdate();
            ps.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void AddTickets(Tickets tickets) {

        try {
            PreparedStatement ps = connection.prepareStatement("INSERT INTO tickets(id,flight_id,name,surname,passport_number,ticket_type)value(null,?,?,?,?,?)");
            ps.setInt(1, tickets.getFlight_id());
            ps.setString(2, tickets.getName());
            ps.setString(3, tickets.getSurname());
            ps.setString(4, tickets.getPassport_number());
            ps.setString(5, tickets.getTicket_type());


            ps.executeUpdate();
            ps.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public ArrayList<Aircrafts> getAircrafts() {
        ArrayList<Aircrafts> aircrafts = new ArrayList<>();
        try {
            PreparedStatement ps = connection.prepareStatement("SELECT*FROM aircrafts");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Long id = rs.getLong("id");
                String name = rs.getString("name");
                String model = rs.getString("model");
                int business_class_capacity = rs.getInt("business_class_capacity");
                int econom_class_capacity = rs.getInt("econom_class_capacity");
                aircrafts.add(new Aircrafts(id, name, model, business_class_capacity, econom_class_capacity));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return aircrafts;
    }


    public ArrayList<Tickets> getTickets() {
        ArrayList<Tickets> tickets = new ArrayList<>();
        try {
            PreparedStatement ps = connection.prepareStatement("SELECT*FROM tickets");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Long id = rs.getLong("id");
                int flight_id = rs.getInt("flight_id");
                String name = rs.getString("name");
                String surname = rs.getString("surname");
                String passport_number = rs.getString("passport_number");
                String ticket_type = rs.getString("ticket_type");
                tickets.add(new Tickets(id, flight_id, name, surname, passport_number, ticket_type));


            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return tickets;
    }


    public ArrayList<Cities> getCities() {
        ArrayList<Cities> cities = new ArrayList<>();
        try {
            PreparedStatement ps = connection.prepareStatement("SELECT*FROM cities");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Long id = rs.getLong("id");
                String name = rs.getString("name");
                String country = rs.getString("country");
                String short_name = rs.getString("short_name");
                cities.add(new Cities(id, name, country, short_name));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return cities;
    }


    public ArrayList<Flights> getFlights() {
        ArrayList<Flights> flights = new ArrayList<>();
        try {
            PreparedStatement ps = connection.prepareStatement("SELECT*FROM flights");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Long id = rs.getLong("id");
                int aircraft_id = rs.getInt("aircraft_id");
                int departure_city_id = rs.getInt("departure_city_id");
                int arrival_city_id = rs.getInt("arrival_city_id");
                String departure_time = rs.getString("departure_time");
                int econom_place_price = rs.getInt("econom_place_price");
                int business_place_price = rs.getInt("business_place_price");

                flights.add(new Flights(id, aircraft_id, departure_city_id, arrival_city_id, departure_time, econom_place_price, business_place_price));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return flights;
    }

    public void updateCities(Cities cities) {
        try {
            PreparedStatement st = connection.prepareStatement("UPDATE cities set  name=?, country=?, short_name=? where id=?");

            st.setString(1, cities.getName());
            st.setString(2, cities.getCountry());
            st.setString(3, cities.getShort_name());
            st.setLong(4, cities.getId());

            st.executeUpdate();
            st.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteCities(Long id) {
        try {

            PreparedStatement st = connection.prepareStatement("DELETE FROM cities where id = ?");
            st.setLong(1, id);
            st.executeUpdate();
            st.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void updateFlights(Flights flights) {
        try {
            PreparedStatement st = connection.prepareStatement("UPDATE flights set  aircraft_id=?, departure_city_id=?, arrival_city_id=?, departure_time=?, econom_place_price=?, business_place_price=? where id=?");

            st.setInt(1, flights.getAircraft_id());
            st.setInt(2, flights.getDeparture_city_id());
            st.setInt(3, flights.getArrival_city_id());
            st.setString(4, flights.getDeparture_time());
            st.setInt(5, flights.getEconom_place_price());
            st.setInt(6, flights.getBusiness_place_price());
            st.setLong(7, flights.getId());

            st.executeUpdate();
            st.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteFlights(Long id) {
        try {

            PreparedStatement st = connection.prepareStatement("DELETE FROM flights where id=?");


            st.setLong(1, id);
            st.executeUpdate();

            st.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void updateTickets(Tickets tickets) {
        try {
            PreparedStatement st = connection.prepareStatement("UPDATE tickets set flight_id=?, name=?, surname=?, passport_number=?, ticket_type=? where id=?");

            st.setInt(1, tickets.getFlight_id());
            st.setString(2, tickets.getName());
            st.setString(3, tickets.getSurname());
            st.setString(4, tickets.getPassport_number());
            st.setString(5, tickets.getTicket_type());
            st.setLong(6, tickets.getId());


            st.executeUpdate();
            st.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteTickets(Long id) {
        try {

            PreparedStatement st = connection.prepareStatement("DELETE FROM tickets where id = ?");


            st.setLong(1, id);
            st.executeUpdate();

            st.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void updateAircrafts(Aircrafts aircrafts) {
        try {
            PreparedStatement st = connection.prepareStatement("UPDATE aircrafts  set name=?, model=?, business_class_capacity=?, econom_class_capacity=? where id=?");
            st.setString(1, aircrafts.getName());
            st.setString(2, aircrafts.getModel());
            st.setInt(3, aircrafts.getBusiness_class_capacity());
            st.setInt(4, aircrafts.getEconom_class_capacity());
            st.setLong(5, aircrafts.getId());


            st.executeUpdate();
            st.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteAircrafts(Long id) {
        try {

            PreparedStatement st = connection.prepareStatement("DELETE FROM aircrafts where id = ?");


            st.setLong(1, id);
            st.executeUpdate();

            st.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}