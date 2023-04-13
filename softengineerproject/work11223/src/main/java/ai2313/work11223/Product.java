/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ai2313.work11223;

/**
 *
 * @author opo25
 */
public class Product {
    private String name;
    private int id;
    private double cost;
    Product(){};
    Product(String name,int id,double cost){
        this.name = name;
        this.id = id;
        this.cost = cost;
    }
    public String getName(){
        return name;
    }
    public int getID(){
        return id;
    }
    public double getCost(){
        return cost;
    }

}
