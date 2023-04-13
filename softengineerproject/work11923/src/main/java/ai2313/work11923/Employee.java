/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ai2313.work11923;

/**
 *
 * @author opo25
 */
public class Employee {
    private double hour,salary;
    private String dept,name;
    private int  id;
    Employee(int id,String name,String dept,double hour){
        this.id=id;
        this.name=name;
        this.dept=dept;
        this.hour=hour;
        if(hour>8){
            this.salary=hour*250;
        }else{
            this.salary=hour*200;
        }
        
    }
    public int getId(){
        return id;
    }
    
    public String getName(){
        return name;       
    }
    
    public String getDept(){
        return dept;
    }
    
    public double getHour(){
        return hour;
    }
    public double getSalary(){
        return salary;
    }
    
}
