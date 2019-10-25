package com.sd.sd_project.model;

import javax.persistence.*;

@Entity
@Table(name = "Products")
public class Product {

    @Id
    @Column(name = "product_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int Id;
    private String name;
    private String type;
    private int price;
    private int nrTotal;
    private int nrBought;
    private double rating = 0;
    private int nrRaters = 0;

    public double getRating() {
        return rating;
    }

    public void setRating(double rating){
        this.rating = rating;
    }

    public int getNrRaters() {
        return nrRaters;
    }

    public void setNrRaters(int nrRaters) {
        this.nrRaters = nrRaters;
    }

    public int getId() {
        return Id;
    }
    public void setId(int id) {
        Id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public int getPrice() {
        return price;
    }
    public void setPrice(int price) {
        this.price = price;
    }
    public int getNrTotal() {
        return nrTotal;
    }
    public void setNrTotal(int nrTotal) {
        this.nrTotal = nrTotal;
    }
    public int getNrBought() {
        return nrBought;
    }
    public void setNrBought(int nrBought) {
        this.nrBought = nrBought;
    }

    public int totalPrice(){
        int price =0;
        price = this.nrBought * this.price;
        return price;
    }

    @Override
    public String toString(){
        String s = "";
        s += "\nId: " + this.getId() +  "\n Name: " + this.getName() + "\n NrTotal: " +
                this.getNrTotal() + "\n NrBought: " + this.getNrBought() + "\n Price: " +
                this.getPrice() + "\n Type: " + this.getType() + "\n Rating: " + this.getRating() + "\n";
        return s;

    }

}
