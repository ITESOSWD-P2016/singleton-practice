package com.iteso.singleton.tables;

import com.iteso.singleton.TableOrder;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: rvillalobos
 * Date: 10/6/13
 * Time: 8:05 PM
 * To change this template use File | Settings | File Templates.
 */
public class Table1 extends TableOrder{

    private static TableOrder uniqueInstance;

    private Table1(){
        tableName = "Table 1";
        drinks = new ArrayList();
        dishes = new ArrayList();
    }
    public static TableOrder getInstance(){
        if(uniqueInstance== null){
            uniqueInstance = new Table1();
        }
        return uniqueInstance;
    }

    public static void clearOrder(){
        uniqueInstance = null;
    }

}
