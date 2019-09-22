package udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.util.Random;

public class UdpServer {
    public static Random random;

    public static void main(String[] args) {
        try {
            DatagramSocket socket = new DatagramSocket(5000);
            while (true) {
                byte[] buf = new byte[1000];
                DatagramPacket pac = new DatagramPacket(buf, buf.length);

                socket.receive(pac);
                String str = new String(pac.getData());
                System.out.println(pac.getAddress());
                System.out.println(pac.getPort());

                int len = pac.getLength();
                str = str.substring(0, len);

                System.out.println("----------------------------");
                System.out.println("String you receive: ");
                System.out.println(str);
                processStr(str);


                //   String strProcess = str.toUpperCase();
                while (true) {
                    String strProcess = processStr(str).toString();
                    DatagramPacket rPac =
                            new DatagramPacket(strProcess.getBytes(), strProcess.length(), pac.getAddress(), pac.getPort());
                    socket.send(rPac);
                }
            }
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Integer processStr(String str) {

    /*    String[] temp = str.split("to");
        String source = temp[1];
        String des = temp[2];
        System.out.println(source + " --> " + des);*/
        random = new Random();

        Integer tygia = 22000 + (100) * random.nextInt(10);
        System.out.println(tygia);
        System.out.println("--------------");
        return tygia;

    }
}
