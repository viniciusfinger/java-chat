package br.com.viniciusfinger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import java.util.Scanner;

public class ChatClient {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o endereço IP do servidor: ");
        String serverIP = scanner.nextLine();


        Socket socket = new Socket(serverIP, 12345);

        PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        System.out.println("Conectado ao servidor. Digite seu usuário:");

        Thread receiveThread = new Thread(() -> {
            try {
                String message;
                while ((message = bufferedReader.readLine()) != null) {
                    System.out.println(message);
                }
            } catch (IOException e) {
                System.out.println("Erro ao receber mensagem.");
            }
        });
        receiveThread.start();

        while (true) {
            String messageToSend = scanner.nextLine();
            writer.println(messageToSend);
        }
    }
}
