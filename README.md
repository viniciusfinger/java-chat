# Javachat ☕️💬

A chat application for the terminal using Java with communication between network sockets using the TCP protocol.

## Features

- **Server-Client Architecture**: A server to manage connections and multiple clients to participate in the chat.
- **Real-time Communication**: Chat with friends in real-time over a network.
- **User Identification**: Enter your username to identify yourself in the chat.

## Prerequisites

Before running the application, ensure you have the following installed:

- **Java 11+** ☕️ (For running the application)

## Installation

1. Clone this repository to your local machine:

   ```bash
   git clone https://github.com/viniciusfinger/java-chat.git
   ```

2. Navigate to the project directory:

   ```bash
   cd java-chat
   ```

## Usage

1. Start the server by running the following command in the terminal:

   ```bash
   java ChatServer
   ```

   This will start the server on port `12345`.

2. Start the client by running the following command in another terminal window:

   ```bash
   java ChatClient
   ```

3. When prompted, enter the server's IP address. If you're running it locally, use `127.0.0.1`.

4. Enter your username and start chatting with your friends!

## Contributing ⚒️

Contributions are always welcome!

## Reference

- [Java SE 8 Socket](https://docs.oracle.com/javase/8/docs/api/java/net/Socket.html)
- [IFSC - Trabalhando com sockets TCP em Java](https://wiki.sj.ifsc.edu.br/index.php/Trabalhando_com_sockets_TCP_em_Java)

Feel free to customize the application to suit your needs. Modify the server-client implementation, enhance the user interface, or add new features!
