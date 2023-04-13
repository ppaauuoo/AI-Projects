package ai2313.sampleadvise;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author opo25
 */
public class Advisor {
    int id;
    String name;
    Student [] stud=new Student[3];
    public Advisor(){}
    public Advisor(int id,String name){
        this.id=id;
        this.name=name;
    }
     public int getId(){
        return id;
    }
    public String getName(){
        return name;
    }
    public void setId(int id){
        this.id = id;
    }
    public void setName(String name){
        this.name=name;
    }
    
    
    public void setStudent(Student stud,int index){
        this.stud[index]=stud;
    }
    public Student [] getStudent(){
        return stud;
    }
    
    public double getGPA(int num){
        int totalcred = stud[num].subj[0].getKit()+stud[num].subj[1].getKit()+stud[num].subj[2].getKit();
        return ((stud[num].subj[0].getGrade()*stud[num].subj[0].getKit()) + (stud[num].subj[1].getGrade()*stud[num].subj[1].getKit()) + (stud[num].subj[2].getGrade()*stud[num].subj[2].getKit()))/totalcred;
    }
} 
