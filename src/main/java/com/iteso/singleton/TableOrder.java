package com.iteso.singleton;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: rvillalobos
 * Date: 10/6/13
 * Time: 7:36 PM
 * To change this template use File | Settings | File Templates.
 */

public abstract class TableOrder {
    public ArrayList dishes;
    public ArrayList drinks;
    public String tableName;

    public void clearDrinks(){
        drinks.clear();
    }

    public void clearDishes(){
        dishes.clear();
    }

    public void addDrink (Drink drink) {
        drinks.add(drink);
    }
    public void addDish (Dish dish) {
        dishes.add(dish);
    }

    public void printCheck(){
        float total = 0;
        Drink dr;
        Dish ds;
        int i;
        System.out.println("Check for " + tableName);
        System.out.println("Drinks:");
        for (i = 0; i < drinks.size(); i++){
            dr = (Drink) drinks.get(i);
            System.out.println(dr.getWaiter() + ": " + dr.getName()+ " " + dr.getPrice());
            total += dr.getPrice();
        }
        System.out.println("Dishes:");
        for (i = 0; i < dishes.size(); i++){
            ds = (Dish) dishes.get(i);
            System.out.println(ds.getWaiter() + ": " + ds.getName()+ " " + ds.getPrice());
            total += ds.getPrice();
        }
        System.out.println("Total: $" + total);

    }


}
