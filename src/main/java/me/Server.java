import java.net.*;
import java.io.*;

public class Server {
    private ServerSocket serverSocket;
    private Socket clientSocket;
    private PrintWriter output;
    private BufferedReader input;

    public Server() {

    }

    public void start(int port) {
        System.out.println("Starting server - stage 0");
        try {
            this.serverSocket = new ServerSocket(port);
            this.clientSocket = serverSocket.accept();

            this.output = new PrintWriter(clientSocket.getOutputStream(), true);
            this.input = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            // if connection was stablished say something
            String greeting = input.readLine();

            if (!greeting.equals("")) {
                output.println("Connection stablished, sendint to client: " + greeting);
            }

        } catch (Exception e) {
            System.out.println(e + " Error when server inits connection");
        }

    }

    public void stop() {
        try {
            this.output.close();
            this.input.close();
            this.serverSocket.close();
            this.clientSocket.close();
        } catch (Exception e) {
            System.out.println(e + " Error when trying to stop the connection");
        }
    }
}
