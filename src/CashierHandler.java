import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class CashierHandler extends  Thread {
    private Socket socket;
    private int id;

    public CashierHandler(Socket socket, int id) {
        this.id = id;
        this.socket = socket;
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
                if (data.operationType.equals("ADD_TICKET")) {

                    db.AddTickets(data.ticket);
                } else if (data.operationType.equals("LIST_TICKET")) {
                    response.tickets = db.getTickets();
                    response.operationType = "";
                    response.ticket = null;
                    os.writeObject(response);
                } else if (data.operationType.equals("DELETE_TICKET")) {
                    response.tickets = db.getTickets();
                    response.operationType = "";
                    response.ticket = null;
                    os.writeObject(response);
                    db.deleteTickets(data.ticket.id);
                } else if (data.operationType.equals("UPDATE_TICKET")) {
                    response.tickets = db.getTickets();
                    response.operationType = "";
                    response.ticket = null;
                    os.writeObject(response);
                    db.updateTickets(data.ticket);

                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
