/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ai2313.inheritance640586;

/**
 *
 * @author opo25
 */
public class FullTime extends Sale{
    protected double tYear;
    public FullTime(){}
    public FullTime(String id,String name,String pos,double salary,double tSale,double tYear){
        super(id,name,pos,salary,tSale);
        this.tYear=tYear;
    }  
    public double gettYear(){
        return tYear;
    }
}
