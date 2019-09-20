package ex03_ta;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class HClient {
    public static String SERVER_IP = "localhost";
    public static int PORT = 5000;
    public static Socket socket;
    public static DataOutputStream dos;
    public static DataInputStream dis;
    public static DataInputStream disC;

    public static void main(String[] args) {
        setUpNetworking();
        sendString();
        //  chat();
    }

    public static void setUpNetworking() {
        try {
            socket = new Socket(SERVER_IP, PORT);
            dis = new DataInputStream(socket.getInputStream());
            dos = new DataOutputStream(socket.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void timer() {
        String timer;
        System.out.println("Time now: ");
        try {
            timer = dis.readUTF();
            System.out.println(timer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void chat() {
        disC = new DataInputStream(System.in);
        String send;
        String receive;
        System.out.println("Start chatting: ");
        try {
            while (true) {
                System.out.print("Client: ");
                send = disC.readLine();
                dos.writeUTF(send);

                receive = dis.readUTF();
                System.out.println("Server: " + receive);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void sendString() {
        disC = new DataInputStream(System.in);
        try {
            String send = disC.readLine();
            dos.writeUTF(send);
            System.out.println("Chuoi in hoa: ");
            String upper = dis.readUTF();
            System.out.println(upper);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
