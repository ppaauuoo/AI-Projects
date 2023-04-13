package ai2313.sampleadvise;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author opo25
 */
public class Subject {
    int id,kit,grade;
    String name;
    public Subject(){}
    public Subject(int id,String name,int kit,int grade){
        this.id=id;
        this.name=name;
        this.kit=kit;
        this.grade=grade;   
    }
    
    public int getId(){
        return id;
    }
    public String getName(){
        return name;
    }
    public int getKit(){
        return kit;
    }
    public int getGrade(){
        return grade;
    }
}
