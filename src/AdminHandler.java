import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class AdminHandler extends Thread {
    private Socket socket;
    private int id;

    public AdminHandler(Socket socket, int id) {
        this.id = id;
        this.socket = socket;
    }

    public AdminHandler() {

    }

    public void run() {
        try {
            DBManager db = new DBManager();
            db.setConnection();

            ObjectOutputStream os = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream is = new ObjectInputStream(socket.getInputStream());
            PackageData data = null;

            while ((data = (PackageData) is.readObject()) != null) {

                PackageData response = new PackageData();
                if (data.operationType.equals("ADD_AIRCRAFT")) {
                    db.AddAircrafts(data.aircraft);
                } else if (data.operationType.equals("LIST_AIRCRAFT")) {
                    response.aircrafts = db.getAircrafts();
                    response.operationType = "";
                    response.aircraft = null;
                    os.writeObject(response);
                } else if (data.operationType.equals("DELETE_AIRCRAFT")) {
                    response.aircrafts=db.getAircrafts();
                    response.operationType="";
                    response.aircraft=null;
                    os.writeObject(response);
                    db.deleteAircrafts(data.aircraft.id);
                } else if (data.operationType.equals("UPDATE_AIRCRAFT")) {
                    response.aircrafts=db.getAircrafts();
                    response.operationType="";
                    response.aircraft=null;
                    os.writeObject(response);
                    db.updateAircrafts(data.aircraft);
                } else if (data.operationType.equals("ADD_CITY")) {
                    db.AddCities(data.city);
                } else if (data.operationType.equals("LIST_CITY")) {
                    response.cities = db.getCities();
                    response.operationType = "";
                    response.city = null;
                    os.writeObject(response);
                } else if (data.operationType.equals("DELETE_CITY")) {
                    response.cities=db.getCities();
                    response.operationType="";
                    response.city=null;
                    os.writeObject(response);
                    db.deleteCities(data.city.id);
                } else if (data.operationType.equals("UPDATE_CITY")) {
                    response.cities = db.getCities();
                    response.operationType = "";
                    response.city = null;
                    os.writeObject(response);
                    db.updateCities(data.city);
                } else if (data.operationType.equals("ADD_FLIGHTS")) {
                    response.aircrafts = db.getAircrafts();
                    response.operationType = "";
                    response.aircraft = null;
                    os.writeObject(response);
                    db.AddFlights(data.flight);
                } else if (data.operationType.equals("LIST_FLIGHTS")) {
                    response.flights = db.getFlights();
                    response.operationType = "";
                    response.flight = null;
                    os.writeObject(response);
                } else if (data.operationType.equals("DELETE_FLIGHTS")) {
                    response.flights = db.getFlights();
                    response.operationType = "";
                    response.flight = null;
                    os.writeObject(response);
                    db.deleteFlights(data.flight.id);
                } else if (data.operationType.equals("UPDATE_FLIGHTS")) {
                    response.flights = db.getFlights();
                    response.operationType = "";
                    response.flight = null;
                    os.writeObject(response);
                    db.updateFlights(data.flight);

                }
            }

        } catch (Exception e) {
            e.printStackTrace();

        }
    }
}
