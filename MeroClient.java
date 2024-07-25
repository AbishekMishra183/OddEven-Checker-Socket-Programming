import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class MeroClient {


    public static void main(String[] args) {
        try {
            System.out.println("Waiting for the server.....");
            Socket socket = new Socket("localhost", 8888);
            System.out.println("connected with the server ");
            // Sending data to server
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
            dos.write(3);



            DataInputStream dis = new DataInputStream(socket.getInputStream());

            String receivedData = dis.readUTF();
            System.out.println(receivedData);
            socket.close();
            System.out.println("client connected :");

            dos.flush();
            dos.close();

        } catch (IOException e) {
            e.printStackTrace();

        }
    }
}
