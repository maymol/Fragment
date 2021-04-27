package com.example.fragment1;

public class Fruitname {

    private String name;
    private String description;
    private String price;
    public Fruitname(String name, String description, String price){

        this.name =name;
        this.description=description;
        this.price=price;}




    public String getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }



}
