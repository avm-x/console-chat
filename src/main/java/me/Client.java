import java.net.*;
import java.io.*;

public class Client {
    private Socket clientSocket;
    private PrintWriter output;
    private BufferedReader input;

    public Client() {
    }

    public void startConnection(String ip, int port) {
        try {
            this.clientSocket = new Socket(ip, port);
            this.output = new PrintWriter(clientSocket.getOutputStream(), true);
            this.input = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            System.out.println("Connection stablished from client");
        } catch (Exception e) {
            System.out.println(e + " Error trying to start connection by client");

        }
    }

    public String sendMessageGetResponse(String msg) {
        try {
            this.output.println(msg);
            String response = this.input.readLine();
            return response;
        } catch (Exception e) {
            System.out.println(e + " Error trying to send and get a message");
            return null;
        }
    }

    public void stopConnection() {
        try {
            this.output.close();
            this.input.close();
            this.clientSocket.close();

        } catch (Exception e) {
            System.out.println(e + " Error trying to stop connection by client");
        }
    }
}
