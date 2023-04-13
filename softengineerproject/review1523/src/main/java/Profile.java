
import javax.swing.JOptionPane;

    /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author opo25
 */
public class Profile {
    static Student [] std = new Student[5];
    //Student [] std = new Student(id,name,surname,grade); 
    int stud = 0;
    public Profile(){
        
    }
    
    public void setStud(Student st){
        if(stud>4){
           JOptionPane.showMessageDialog(null,"Full!");
        }else{
            std[stud] = st;
            //JOptionPane.showMessageDialog(null,std[stud].getName());
            stud++;
            JOptionPane.showMessageDialog(null,"Save Successfully");
        }
    }
    
    public Student[] getStud(){
        return std;
    }
    public int getIndex(){
        return stud;
    }
}
