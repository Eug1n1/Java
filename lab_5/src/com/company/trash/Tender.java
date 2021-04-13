package com.company.trash;

public class Tender
{
    private int price;
    private String winner;

    public int getPrice() {
        return price;
    }

    public void setPrice(int price, String name) {
        this.price = price;
        this.winner = name;
    }

    public String getWinner() {
        return winner;
    }

    public Tender(int price)
    {
        this.price =price;
    }
}
