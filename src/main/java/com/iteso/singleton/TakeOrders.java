package com.iteso.singleton;

import com.iteso.singleton.tables.Table1;
import com.iteso.singleton.tables.Table2;
import com.iteso.singleton.tables.Table4;

/**
 * Created with IntelliJ IDEA.
 * User: rvillalobos
 * Date: 10/6/13
 * Time: 7:36 PM
 * To change this template use File | Settings | File Templates.
 */
public class TakeOrders {
    public static void main (String[] args){
        TableOrder order;
        Drink drink;
        Dish dish;

        order = Table4.getInstance();

        drink = new Drink();
        drink.setName("Coke");
        drink.setWaiter("Waiter A");
        drink.setPrice(10);
        order.addDrink(drink);

        order = Table1.getInstance();
        drink = new Drink();
        drink.setName("Coke");
        drink.setWaiter("Waiter B");
        drink.setPrice(10);
        order.addDrink(drink);

        order = Table4.getInstance();
        drink = new Drink();
        drink.setName("Coke");
        drink.setWaiter("Waiter B");
        drink.setPrice(10);
        order.addDrink(drink);

        order = Table4.getInstance();

        dish = new Dish();
        dish.setName("Enchilada");
        dish.setPrice(8);
        dish.setWaiter("Waiter C");
        order.addDish(dish);

        dish = new Dish();
        dish.setName("Enchilada");
        dish.setPrice(8);
        dish.setWaiter("Waiter C");
        order.addDish(dish);

        order = Table4.getInstance();
        dish = new Dish();
        dish.setName("Chicken Pozole");
        dish.setPrice(45);
        dish.setWaiter("Waiter B");
        order.addDish(dish);

        order = Table2.getInstance();
        dish = new Dish();
        dish.setName("Tostada de Pata");
        dish.setPrice(28);
        dish.setWaiter("Waiter D");
        order.addDish(dish);

        order = Table4.getInstance();
        dish = new Dish();
        dish.setName("Quesadilla Chicharron");
        dish.setPrice(18);
        dish.setWaiter("Waiter A");
        order.addDish(dish);

        order = Table4.getInstance();
        dish = new Dish();
        dish.setName("Tostada de Pata");
        dish.setPrice(28);
        dish.setWaiter("Waiter D");
        order.addDish(dish);

        order = Table1.getInstance();
        order.printCheck();

        order = Table4.getInstance();
        order.printCheck();

        Table4.clearOrder();

        order = Table4.getInstance();
        dish= new Dish();
        dish.setName("Quesadilla Rajas");
        dish.setPrice(18);
        dish.setWaiter("Waiter E");
        order.addDish(dish);

        order.printCheck();
    }


}
