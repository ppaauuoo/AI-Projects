/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ai2313.inheritance640586;

/**
 *
 * @author opo25
 */
public class Employee {
    protected String name,pos,id;
    protected double salary;
    public Employee(){}
    public Employee(String  id, String name,String pos,double salary){
        this.id=id;
        this.name=name;
        this.pos=pos;
        this.salary=salary;
    }
    
    public String getID(){
        return id;
    }
    public String getName(){
        return name;
    }
    public String getPos(){
        return pos;
    }
    public double getSalary(){
        return salary;
    }
    
    
}
