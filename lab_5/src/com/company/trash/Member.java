package com.company.trash;

public class Member implements Runnable
{

    Integer My_Price;
    Integer My_Price4;
    Integer My_Price2;
    String name;
    int count=1;
    public Integer My_Price3;
    public Member(Integer price)
    {
        this.My_Price=price;
    }

    @Override
    public void run()
    {

        My_Price2 = My_Price;
        if (count == 1) {
            My_Price3 = My_Price;
            count++;
        }
        My_Price4 = (int) (Math.random() * My_Price2);
        Tender my_tend = new Tender(My_Price4);
        System.out.println("Я "+Thread.currentThread().getName()+" Моя заявка:" + my_tend.Price);
        if (My_Price3 > My_Price4) {
            My_Price3 = My_Price4;
            name = Thread.currentThread().getName();
        }
    }
    public void Winner()
    {
        System.out.println("Победил:"+name+"\n"+"Цена:"+My_Price3);
    }
}