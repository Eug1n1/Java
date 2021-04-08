package com.company.main;

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
            Thread read = new Thread(new Runnable() {
                @Override
                public void run() {
                    String str;
                    try {
                        while (!stop) {
                            str = finalBr.readLine();

                            if (str == null)
                            {
                                break;
                            }

                            System.out.println(str);
                        }
                    } catch (IOException e) {
                    }
                }
            });

            read.start();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
