package br.com.viniciusfinger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ChatServer {
    static List<ClientHandler> clients = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(12345);
        System.out.println("[Java Chat] Servidor iniciado. Aguardando usuários conectarem.");

        while (true){
            Socket clientSocket = serverSocket.accept();

            System.out.println("Usuário conectado: " + clientSocket.getInetAddress().getHostAddress());

            ClientHandler clientHandler = new ClientHandler(clientSocket);
            clients.add(clientHandler);

            Thread clientHandlerThread = new Thread(clientHandler);
            clientHandlerThread.start();
        }
    }
}

class ClientHandler implements Runnable {
    private Socket clientSocket;
    private PrintWriter writer;
    private BufferedReader bufferedReader;
    private String username;

    public ClientHandler(Socket socket) throws IOException {
        this.clientSocket = socket;
        writer = new PrintWriter(socket.getOutputStream(), true);

        bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        username = bufferedReader.readLine();
    }

    @Override
    public void run() {
        try {
            String message;
            while ((message = bufferedReader.readLine()) != null) {
                message = this.username + " diz: " + message;
                System.out.println(message);

                //notifica todos os subscribers
                for (ClientHandler client : ChatServer.clients) {
                    if (client != this) {
                        client.sendMessage(message);
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Erro ao processar mensagem: " + e.getCause());
        } finally {
            try {
                bufferedReader.close();
                writer.close();
                clientSocket.close();
            } catch (IOException e) {
                System.out.println("Error closing connections." + e.getCause());
            }
        }
    }

    public void sendMessage(String message) {
        writer.println(message);
    }
}
