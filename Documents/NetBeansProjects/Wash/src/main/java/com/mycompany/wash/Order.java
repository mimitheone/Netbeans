/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.wash;

/**
 *
 * @author the_one
 */
public class Order {
   String  item;
   int amount;
   double weight;
   double totalWeight;

    public Order(String item, int amount, double weight, double totalWeight) {
        this.item = item;
        this.amount = amount;
        this.weight = weight;
        this.totalWeight = totalWeight;
    }

    public String getItem() {
        return item;
    }

    public int getAmount() {
        return amount;
    }

    public double getWeight() {
        return weight;
    }

    public double getTotalWeight() {
        return totalWeight;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public void setTotalWeight(double totalWeight) {
        this.totalWeight = totalWeight;
    }
    
}
