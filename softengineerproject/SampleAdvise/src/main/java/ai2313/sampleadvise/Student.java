package ai2313.sampleadvise;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author opo25
 */
public class Student {
    int id;
    String name;
    Subject [] subj=new Subject[3];
    //int index=0;
    public Student(){}
    public Student(int id,String name){
        this.id=id;
        this.name=name;
    }
     public int getId(){
        return id;
    }
    public String getName(){
        return name;
    }
    
    
    public void setSubject(Subject stud,int index){
        this.subj[index]=stud;
    }
    public Subject [] getSubject(){
        return subj;
    }
}