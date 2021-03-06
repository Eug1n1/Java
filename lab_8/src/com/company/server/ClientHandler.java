package com.company.server;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;
import java.net.InetAddress;

public class ClientHandler implements Runnable {
    private Server server;
    private PrintWriter outMessage;
    private Scanner inMessage;
    private InetAddress addr;
    private static final String HOST = "127.0.0.1";
    private static final int PORT = 3000;
    private Socket clientSocket = null;
    private static int clients_count = 0;

    public ClientHandler(Socket socket, Server server) {
        try {
            clients_count++;
            this.server = server;
            this.clientSocket = socket;
            this.outMessage = new PrintWriter(socket.getOutputStream());
            this.inMessage = new Scanner(socket.getInputStream());
            this.addr = clientSocket.getInetAddress();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void run() {
        try {
            while (true) {
                if (inMessage.hasNext()) {
                    String clientMessage = inMessage.nextLine();

                    if (clientMessage.equalsIgnoreCase("##session##end##")) {
                        break;
                    }
                    System.out.println(clientMessage);
                    server.sendMessageToAllClients(addr.getHostName() + ": " + clientMessage);
                }
                Thread.sleep(100);
            }
        }
        catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        finally {
            this.close();
        }
    }

    public void sendMsg(String msg) {
        try {
            outMessage.println(msg);
            outMessage.flush();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void close() {
        server.removeClient(this);
        clients_count--;
        server.sendMessageToAllClients("Клиентов в чате = " + clients_count);
    }
}