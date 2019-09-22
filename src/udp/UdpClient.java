package udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class UdpClient {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            DatagramSocket socket = new DatagramSocket();
            while (true) {
                System.out.println("--------------------------");
                System.out.println("Please enter information you want to send:");
                String str = scanner.next();
                DatagramPacket pac =
                        new DatagramPacket(str.getBytes(), str.length(), InetAddress.getByName("localhost"), 5000);

                socket.send(pac);



                byte [] buf = new byte[1000];
                while (true) {
                    DatagramPacket rPac = new DatagramPacket(buf, buf.length);
                    socket.receive(rPac);
                    String receiveStr = new String(rPac.getData()).substring(0, rPac.getLength());
                    System.out.println("-----------------------");
                    System.out.println(receiveStr);
                }

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
