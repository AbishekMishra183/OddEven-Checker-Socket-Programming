import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.StandardSocketOptions;

public class MeroServer {
    public static void main(String[] args) {
        try {
            System.out.println("server stating.......");
            ServerSocket serverSocket = new ServerSocket(8888);
            System.out.println("server up and running ......");
            Socket s = serverSocket.accept();
            System.out.println("server connected");
            DataInputStream dis = new DataInputStream(s.getInputStream());
            int result = dis.read();
            String dataToSend = checkEvenOdd(result);


            DataOutputStream dos = new DataOutputStream(s.getOutputStream());
            dos.writeUTF(dataToSend);

            System.out.println(result);
        } catch (IOException e) {
            e.printStackTrace();

        }
    }




    private static String checkEvenOdd(int result) {
        if (result % 2 == 0) {
            return "Even";
        } else {
            return "odd";
        }
    }

}
