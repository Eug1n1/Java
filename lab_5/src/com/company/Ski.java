package com.company;

import com.company.trash.Client;

public class Ski {

    static Integer n = 10;

    public static void main(String[] args) {
        Client cli1 = new Client(n);
        while(true)
        {
            try
            {
                Thread thr1=new Thread(cli1,"Pensioner");
                Thread thr2=new Thread(cli1,"Client");
                Thread thr3=new Thread(cli1,"Pensioner");
                Thread thr4=new Thread(cli1,"Client");
                Thread thr5=new Thread(cli1,"Client");
                thr1.start();
                //thr1.join();
                thr3.start();
                thr3.join();
                thr2.start();
                thr4.start();
                thr5.start();
                Thread.sleep(1000);
            }
            catch(Exception e)
            {
            }
        }
    }
}
