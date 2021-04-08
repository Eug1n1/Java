package com.company.udp;

import java.net.*;
import java.io.*;
import java.util.Date;

public class Server{

    private String host;

    private int port;

    public Server(String host, int port) {
        this.host = host;
        this.port = port;
    }


    private void sendMessage(String mes){
        try{
            byte[] data = mes.getBytes();
            InetAddress addr = InetAddress.getByName(host);
            DatagramPacket pack = new DatagramPacket(data, data.length, addr, port);
            DatagramSocket ds = new DatagramSocket();
            ds.send(pack);
            ds.close();
        }catch(IOException e){
            System.err.println(e);
        }

    }

    public static void main(String[] args) throws InterruptedException {
        Server srv = new Server("127.0.0.1", 3000);
        while(true) {
            srv.sendMessage(new Date().toString());
            Thread.sleep(2000);
        }
    }

}