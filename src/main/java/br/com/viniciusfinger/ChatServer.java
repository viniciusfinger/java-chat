package br.com.viniciusfinger;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ChatServer {

    public static void main(String[] args) throws IOException {
        ServerSocket socket = new ServerSocket(12345);

        while(Boolean.TRUE){
            Socket clientSocket = socket.accept();
            System.out.println("Usuário conectado: " + clientSocket.getInetAddress().getHostAddress());
        }
    }
}

class ClientHandler implements Runnable {

    @Override
    public void run() {

    }
}