package com.anda.assignment2.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    private int quantity;
    private int calories;
    private Date purchaseDate;
    private Date expirationDate;
    private Date consumptionDate;

    public Item() {
        this.name = "";
        this.quantity = 0;
        this.calories = 0;
        this.purchaseDate = null;
        this.expirationDate = null;
        this.consumptionDate = null;
    }

    public Item(String name, int quantity, int calories, Date expirationDate, Date purchaseDate) {
        this.name = name;
        this.quantity = quantity;
        this.calories = calories;
        this.expirationDate = expirationDate;
        this.purchaseDate = purchaseDate;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getCalories() {
        return calories;
    }

    public Date getPurchaseDate() {
        return purchaseDate;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public Date getConsumptionDate() {
        return consumptionDate;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPurchaseDate(Date purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public void setConsumptionDate(Date consumptionDate) {
        this.consumptionDate = consumptionDate;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", quantity=" + quantity +
                ", calories=" + calories +
                ", purchaseDate=" + purchaseDate +
                ", expirationDate=" + expirationDate +
                ", consumptionDate=" + consumptionDate +
                '}';
    }

    public boolean waste() {
        Date current= new Date();
        if(this.getConsumptionDate() == null && current.compareTo(this.getExpirationDate()) > 0) {
            return true;
        }
        else return false;
    }
}

