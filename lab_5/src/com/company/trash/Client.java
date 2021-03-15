package com.company.trash;

import java.util.Random;

public class Client implements Runnable
{
    Integer CommonResource;
    int gave;
    Integer gave1;
    public Client(Integer commonResource)
    {
        this.CommonResource=commonResource;
    }
    @Override
    public synchronized void  run() {



        if(CommonResource>0) {
            synchronized (CommonResource) {
                System.out.println("Забрал лыжи " + Thread.currentThread().getName());
                System.out.println(CommonResource);
                CommonResource--;
            }
        }
        else
        {
            synchronized (CommonResource) {
                System.out.println("No ski");
                gave=(int) (Math.random()*11);
                gave1=gave;
                CommonResource +=gave1 ;
            }
        }



    }
}
