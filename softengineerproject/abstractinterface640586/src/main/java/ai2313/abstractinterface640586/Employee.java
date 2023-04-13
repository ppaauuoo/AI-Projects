/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ai2313.abstractinterface640586;

import javax.swing.JOptionPane;

/**
 *
 * @author opo25
 */
public class Employee extends Person implements Programmer {
    private String empID,position;
    private double salary;
    
    public Employee(){}
    public Employee(String empID,String position,double salary){
        this.empID=empID;
        this.position=position;
        this.salary=salary;
    }
    
    public void setEmpID(String empID){
        this.empID=empID;
    }
    public void setPosition(String position){
        this.position=position;
    }
    public void setSalary(double salary){
        this.salary=salary;
    }
    public String getEmpID(){
        return empID;
    }
    public String getPosition(){
        return position;
    }
    public double getSalary(){
        return salary;
    }
    
    void setID(String ID){
        this.ID=ID;
    }
    void setName(String name){
        this.name=name;
    }
    void setSurname(String surname){
        this.surname=surname;
    }
    public void code(){
        JOptionPane.showMessageDialog(null,"I'm coding for developing a program.");
    }
    public void sleep(){
        JOptionPane.showMessageDialog(null,"I fell asleep at work.");
    }
    public void die(){
        JOptionPane.showMessageDialog(null,"I have not finished my work.");
    }
    
    
    
    
}
