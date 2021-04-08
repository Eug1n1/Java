package com.company.chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    public static boolean stop = false;

    public static void main(String[] args) {
        Socket socket = null;
        BufferedReader br = null;
        Scanner scan = new Scanner(System.in);
        try {
            // установка соединения с сервером
            socket = new Socket("127.0.0.1", 3000);
            PrintStream ps = new PrintStream(socket.getOutputStream());
            br = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            BufferedReader finalBr = br;
            Thread read = new Thread(() -> {
                String str;
                try {
                    while (!stop) {
                        str = finalBr.readLine(); // ждем сообщения с сервера
                        System.out.println(str);
                    }
                } catch (IOException e) {}
            });

            Thread post = new Thread(() -> {
                while (!stop) {
                    String userWord;
                    userWord = scan.next(); // сообщения с консоли
                    if (userWord.equals("stop")) {
                        stop = true; // выходим из цикла если пришло "stop"
                    } else {
                        ps.println(userWord); // отправляем на сервер
                    }
                    ps.flush(); // чистим

                }
            });

            read.start();
            post.start();

//            while (true) {
//                String str = scan.next();
//                ps.println(str);
//                br.readLine();
//            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
