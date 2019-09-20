package ex03_ta;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class HServer {
    public static int PORT = 5000;
    public static ServerSocket serverSocket;
    public static Socket socket;
    public static DataOutputStream dos;
    public static DataInputStream dis;
    public static DataInputStream disS;

    public static void main(String[] args) {
        go();
    }

    public static void go() {
        try {
            serverSocket = new ServerSocket(PORT);
            while (true) {
                socket = serverSocket.accept();
                dis = new DataInputStream(socket.getInputStream());
                dos = new DataOutputStream(socket.getOutputStream());
                System.out.println("Start chatting: ");
                //chat();
                processString();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void timer() {
        String timer = new Date().toString();
        try {
            dos.writeUTF(timer);
            System.out.println(timer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void chat() {
        disS = new DataInputStream(System.in);
        String send;
        String receive;
        try {
            while (true) {
                receive = dis.readUTF();
                System.out.println("Client: " + receive);
                System.out.print("Server: ");
                send = disS.readLine();
                dos.writeUTF(send);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void processString(){
        try {
            String receiveStr = dis.readUTF();
            System.out.println(receiveStr);
             receiveStr =receiveStr.toUpperCase();
             dos.writeUTF(receiveStr);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
