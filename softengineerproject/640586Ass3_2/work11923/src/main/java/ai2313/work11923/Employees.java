/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ai2313.work11923;

/**
 *
 * @author opo25
 */
public class Employees {
    Employee [] em = new Employee[10];
    int index=0;
    void setEmployee(Employee e){
        em[index++]=e;
    }
    Employee[] getEmployee(){
        return em;
    }
    Employee getCurrent(){
        int cindex=index-1;
        return em[cindex]; 
    }
    int getIndex(){
        return index;
    }
}
