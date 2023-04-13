/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ai2313.inheritance640586;

/**
 *
 * @author opo25
 */
public class PartTime extends Sale{
    public CalculateSalary cal = new CalculateSalary();
    protected double tDay;
    public PartTime(){}
    public PartTime(String id,String name,String pos,double salary,double tSale,double tDay){
        super(id,name,pos,salary,tSale);
        this.tDay=tDay;
    }
    
    public double gettDay(){
        return tDay;
    }
    
}
