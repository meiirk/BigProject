import java.net.ServerSocket;
import java.net.Socket;

public class Admin_Server {
    public static void main(String[] args) {

        try {
            ServerSocket server = new ServerSocket(1990);
            int id = 0;
            while (true) {
                Socket socket = server.accept();
                id++;
                System.out.println(id + ") " + "Admin is connected!");

                AdminHandler th = new AdminHandler(socket, id);
                th.start();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
