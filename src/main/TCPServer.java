package main;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(65256);
        while (true) {
            Socket socket = serverSocket.accept();
            new LengthCalculator(socket).start();
        }
    }
}
