/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ai2313.inheritance640586;

/**
 *
 * @author opo25
 */
public class Manager extends Employee{
    public Manager(String id,String name,String pos,double salary,int tTime)
    {
        super(id,name,pos,salary+5000+(500*tTime));
    }
}
