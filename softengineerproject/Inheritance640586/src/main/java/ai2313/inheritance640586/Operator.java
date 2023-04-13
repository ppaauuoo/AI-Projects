/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ai2313.inheritance640586;

/**
 *
 * @author opo25
 */
public class Operator extends Employee {
    protected int tHour;    
    public Operator(String id,String name,String pos,double salary,int tHour)
        {
            super(id,name,pos,salary+(tHour*=200));
        }
}
