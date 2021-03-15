package com.company;

import com.company.trash.Client;
import com.company.trash.Member;
import com.company.trash.Tender;

public class Main {

        static Integer n=10;

        static int zayavki;
        static int count=0;

        public static void main(String[] args)
        {
            Client cli1 = new Client(n);
            Tender tender = new Tender(1000);
            Member member = new Member(tender.Price);
            zayavki = (int) (Math.random() * 11);
            try {
                while (count < zayavki)
                {
                    Thread thr1 = new Thread(member, "Member1");
                    Thread thr2 = new Thread(member, "Member2");
                    Thread thr3 = new Thread(member, "Member3");
                    thr1.start();
                    thr1.join();
                    thr2.start();
                    thr2.join();
                    thr3.start();
                    thr3.join();
                    count++;
                }
                member.Winner();
            }catch (InterruptedException e)
            {
                System.out.println(e.getMessage());
            }
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
