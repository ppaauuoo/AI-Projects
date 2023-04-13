package ai2313.abstractinterface640586;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author opo25
 */
abstract class Person {
    protected String ID,name,surname;
    
    abstract void setID(String ID);
    
    abstract void setName(String name);
    
    abstract void setSurname(String surname);
    
    String getID(){
        return ID;
    }
    
    String getName(){
        return name;
    }
    
    String getSurname(){
        return surname;
    }
    
    
}
