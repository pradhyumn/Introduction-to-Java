package chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashSet;
import java.util.Set;

public class ChatServer {
    private static final int PORT = 9898;
    private static Set<String> clientNames = new HashSet<>();
    private static Set<PrintWriter> clientWriters = new HashSet<>();

    public static void main(String[] args) throws IOException {
        System.out.println("The chat server is running.");
        ServerSocket serverSocket = new ServerSocket(PORT);
        try {
            while (true) {
                new ClientHandler(serverSocket.accept()).start();
            }
        } finally {
            serverSocket.close();
        }
    }

    private static class ClientHandler extends Thread {
        private String name;
        private Socket clientSocket;
        private BufferedReader in;
        private PrintWriter out;

        public ClientHandler(Socket clientSocket) {
            this.clientSocket = clientSocket;
        }

        public void run() {
            try {
                // Create input and output streams for the client
                in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                out = new PrintWriter(clientSocket.getOutputStream(), true);

                // Get the client's name and add it to the set of names
                while (true) {
                    out.println("SUBMIT_NAME");
                    name = in.readLine();
                    if (name == null) {
                        return;
                    }
                    synchronized (clientNames) {
                        if (!clientNames.contains(name)) {
                            System.out.println("User " + name + " has joined the chat");
                            clientNames.add(name);
                            break;
                        }
                    }
                }

                // Tell the client that their name was accepted
                out.println("NAME_ACCEPTED");

                // Add the client's PrintWriter to the set of writers
                synchronized (clientWriters) {
                    clientWriters.add(out);
                }

                // Broadcast a message to all clients that a new user has joined
                for (PrintWriter writer : clientWriters) {
                    writer.println("MESSAGE " + name + " has joined the chat.");
                }

                // Read messages from the client and broadcast them to all other clients
                while (true) {
                    String message = in.readLine();
                    if (message == null) {
                        return;
                    }
                    for (PrintWriter writer : clientWriters) {
                        writer.println("MESSAGE " + name + ": " + message);
                    }
                }
            } catch (IOException e) {
                System.out.println(e);
            } finally {
                // Remove the client's name and PrintWriter from the sets
                if (name != null) {
                    clientNames.remove(name);
                    System.out.println("User " + name + " has left the chat");
                }
                if (out != null) {
                    clientWriters.remove(out);
                }
                try {
                    clientSocket.close();
                } catch (IOException e) {
                }
            }
        }
    }
}
