package hfjava;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class DailyAdviceClient {
    public void go() {
        try {
            Socket s = new Socket("localhost", 4242);
            InputStreamReader streamReader = new InputStreamReader(s.getInputStream());
            BufferedReader bufferedReader = new BufferedReader(streamReader);

            String advice = bufferedReader.readLine();
            System.out.println("To day you should: " + advice);
            bufferedReader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        DailyAdviceClient client = new DailyAdviceClient();
        client.go();
    }
}
