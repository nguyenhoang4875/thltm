package ex02;

import java.net.ServerSocket;
import java.net.Socket;

public class HServer {
    public static ServerSocket serverSocket ;
    public static int PORT = 5000;
    public static void main(String[] args) {
        try {
            serverSocket = new ServerSocket(PORT);
            Socket socket = serverSocket.accept();





        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
