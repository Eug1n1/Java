package com.company;

import com.company.trash.Client;
import com.company.trash.Member;
import com.company.trash.Tender;

import java.util.concurrent.Semaphore;

public class Main {

        static Integer n=10;

        static int zayavki;
        public static int count=0;

        public static void main(String[] args) throws InterruptedException {
            Client cli1 = new Client(n);
            Tender tender = new Tender(1000);
            Semaphore semaphore = new Semaphore(1, true);
            Member member = new Member(tender, 20, semaphore);
            Member member2 = new Member(tender, 10, semaphore);
            Member member3 = new Member(tender, 10, semaphore);


            count = 3;
            Thread thr1 = new Thread(member, "Member1");
            Thread thr2 = new Thread(member2, "Member2");
            Thread thr3 = new Thread(member3, "Member3");
            thr1.start();
            thr2.start();
            thr3.start();
            thr1.join();
            thr2.join();
            thr3.join();

            System.out.printf("WINNER: %s \tPrice: %d%n", tender.getWinner(), tender.getPrice());

//            while(true)
//            {
//                try
//                {
//                    Thread thr1=new Thread(cli1,"Pensioner");
//                    Thread thr2=new Thread(cli1,"Client");
//                    Thread thr3=new Thread(cli1,"Pensioner");
//                    Thread thr4=new Thread(cli1,"Client");
//                    Thread thr5=new Thread(cli1,"Client");
//                    thr1.start();
//                    //thr1.join();
//                    thr3.start();
//                    thr3.join();
//                    thr2.start();
//                    thr4.start();
//                    thr5.start();
//                    Thread.sleep(1000);
//                }
//                catch(Exception e)
//                {
//                }
//            }
        }
}
