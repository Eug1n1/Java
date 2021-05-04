package com.company.trash;

import com.company.Main;
import java.util.Random;
import java.util.concurrent.Semaphore;

public class Member implements Runnable {
    Tender tender;
    Integer minPrice;
    Random rnd;
    int count;
    Semaphore sem;
    
    public Member(Tender tender, int count, Semaphore sem)
    {
        this.tender = tender;
        this.count = count;
        this.sem = sem;
        this.rnd = new Random();
        this.minPrice = rnd.nextInt(180) + 100;
    }

    @Override
    public void run()
    {
        while (Main.count > 1)
        {
            try
            {
                sem.acquire();
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }

            if(tender.getWinner() == Thread.currentThread().getName() && Main.count == 1)
            {
                sem.release();
                break;
            }

            int price = tender.getPrice();
            if(price <= minPrice)
            {
                Main.count--;
                System.out.printf("closed2 %s%n", Thread.currentThread().getName());
                sem.release();
                break;
            }

            int decr = rnd.nextInt(100) + 2;

            if(price - decr <= minPrice)
            {
                tender.setPrice(minPrice, Thread.currentThread().getName());
                System.out.printf("Name: %s\t Price: %d \t Count: %d MIN: %d%n", Thread.currentThread().getName(), tender.getPrice(), Main.count, minPrice);
                Main.count--;
                sem.release();
                System.out.printf("closed1 %s%n", Thread.currentThread().getName());
                break;
            }
            else {
                    tender.setPrice(price - decr, Thread.currentThread().getName());
            }
            System.out.printf("Name: %s\t Price: %d \t Count: %d MIN: %d%n", Thread.currentThread().getName(), tender.getPrice(), Main.count, minPrice);
            count--;
            sem.release();
        }
    }
}