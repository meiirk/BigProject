import java.net.ServerSocket;
import java.net.Socket;

public class CASHIER_Server {
    public static void main(String[] args) {

     try{
      ServerSocket server=new ServerSocket(1989);
      int id=0;
      while (true){
          Socket socket=server.accept();
          id++;
          System.out.println(id +") "+ "Cashier is connected!");

        CashierHandler th=new CashierHandler(socket,id);
        th.start();
      }

        }catch(Exception e){
      e.printStackTrace();
  }
    }



}
