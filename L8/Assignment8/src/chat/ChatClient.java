package chat;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ChatClient extends JFrame {
    private static final long serialVersionUID = 1L;
    private String clientName;
    private BufferedReader inputReader;
    private PrintWriter outputWriter;
    private JTextArea chatArea;
    private JTextField inputField;

    public ChatClient(String clientName, String serverHost, int serverPort) {
        this.clientName = clientName;

        // Set up UI
        setTitle("Chat Client");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Set up components
        chatArea = new JTextArea();
        chatArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(chatArea);
        inputField = new JTextField();
        JButton sendButton = new JButton("Send");
        sendButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sendMessage();
            }
        });

        // Add components to content pane
        Container contentPane = getContentPane();
        contentPane.add(scrollPane, BorderLayout.CENTER);
        JPanel inputPanel = new JPanel(new BorderLayout());
        inputPanel.add(inputField, BorderLayout.CENTER);
        inputPanel.add(sendButton, BorderLayout.EAST);
        contentPane.add(inputPanel, BorderLayout.SOUTH);

        // Show UI
        setVisible(true);

        // Connect to server
        if (!connectToServer(serverHost, serverPort)) {
            JOptionPane.showMessageDialog(this, "Could not connect to server.");
            System.exit(1);
        }
    }

    private boolean connectToServer(String serverHost, int serverPort) {
        try {
            Socket socket = new Socket(serverHost, serverPort);
            inputReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            outputWriter = new PrintWriter(socket.getOutputStream(), true);

            // Send the client's name to the server
            outputWriter.println(clientName);

            // Read messages from the server and append them to the chat area
            while (true) {
                String line = inputReader.readLine();
                if (line.startsWith("SUBMITNAME")) {
                    outputWriter.println(clientName);
                } else if (line.startsWith("NAMEACCEPTED")) {
                    inputField.setEditable(true);
                } else if (line.startsWith("MESSAGE")) {
                    chatArea.append(line.substring(8) + "\n");
                }
            }
        } catch (IOException e) {
            return false;
        }
    }

    private void sendMessage() {
        // Send the user's message to the server
        outputWriter.println(inputField.getText());
        inputField.setText("");
    }

    public static void main(String[] args) {
        // Get the user's name
        String clientName = JOptionPane.showInputDialog("Enter your name:");

        // Get the server host and port
        String serverHost = JOptionPane.showInputDialog("Enter the server host:");
        int serverPort = Integer.parseInt(JOptionPane.showInputDialog("Enter the server port:"));

        // Start the client
        ChatClient chatClient = new ChatClient(clientName, serverHost, serverPort);
    }
}
