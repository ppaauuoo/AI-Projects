/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ai2313.inheritance640586;

/**
 *
 * @author opo25
 */
public class Sale extends Employee {
    //CalculateSalary cal = new CalculateSalary();
    protected double tSale;
    public Sale(){}
    public Sale(String id, String name, String pos,double salary,double tSale){
        super(id,name,pos,salary);
        this.tSale=tSale;
    }
    
    public void settSale(double tSale){
        this.tSale=tSale;
    }
    
    public double gettSale(){
        return tSale;
    }
    

        
}
