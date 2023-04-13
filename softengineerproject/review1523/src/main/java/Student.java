
import javax.swing.JOptionPane;

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
    double grade;
    String name,surname;
    
    public Student(){

    }
    
    public Student(int id, String name,String surname,Double grade){
            this.id = id;
            this.name = name;
            this.surname = surname;
            this.grade = grade;
            
        }

    public int getId(){
        return id;
    }
    public String getName(){
        return name;
    }
    public String getSurname(){
        return surname;
    }
    public Double getGrade(){
        return grade;
    }
}
