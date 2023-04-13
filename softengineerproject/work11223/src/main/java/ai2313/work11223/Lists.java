/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ai2313.work11223;

import javax.swing.JOptionPane;

/**
 *
 * @author opo25
 */
public class Lists {
    List [] ls = new List[100];
    int index = 0;
    public void setLs(List l){
      ls[index++]=l;  
    }
    public void setLs(List l,int index){
      ls[index]=l;  
    }
    public List [ ] getLs(){
        return ls;
    }
    public int getIndex(){
        return index;
    }
    public boolean checkLs(int pdindex){
        for(int i =0;i<index;i++){
            if(ls[i].getPDIndex()==pdindex){
                return true;
            }
        }
        return false;
    }
}
