package ex01;

import java.io.IOException;
import java.net.ServerSocket;

public class CongLocalHost {
    public static void main(String[] args) {
        ServerSocket ss;
        for(int i=0;i<1029;i++){
            try{
                ss= new ServerSocket(i);
                ss.close();
                System.out.println("done");
            }catch(IOException e)
            { System.out.println("Co mot server tren cong "+i);}
        }
    }
}
