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
public class Student extends Person implements Programmer {
    private String stdID,dept,fac;
    private double gpa;
    
    public Student(){};
    public Student(String stdID,String dept,String fac,double gpa){
        this.stdID=stdID;
        this.dept=dept;
        this.fac=fac;
        this.gpa=gpa;
    }
    
    public void setStdID(String stdID){
        this.stdID=stdID;
    }
    public void setDept(String dept){
        this.dept=dept;
    }
    public void setFac(String fac){
        this.fac=fac;
    }
    public void setGpa(double gpa){
        this.gpa=gpa;
        if(gpa<0.0||gpa>4.0)
            this.gpa=0.0;
    }
    public String getStdID(){
        return stdID;
    }
    public String getDept(){
        return dept;
    }
    public String getFac(){
        return fac;
    }
    public double getGpa(){
        return gpa;
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
        JOptionPane.showMessageDialog(null,"I'm learning Programming.");
    }
    public void sleep(){
        JOptionPane.showMessageDialog(null,"I fell asleep in the classroom.");
    }
    public void die(){
        JOptionPane.showMessageDialog(null,"I failed my exam.");
    }
}
