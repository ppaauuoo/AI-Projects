/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ai2313.work11223;

/**
 *
 * @author opo25
 */
public class List {
    private int pdindex;
    private int no;
    public List(){}
    public List(int pd,int no){
        this.pdindex =pd;
        this.no = no;
    }
    public int getPDIndex(){
        return pdindex;
    }
    public int getNo(){
        return no;
    }
    public void setNo(int no){
        this.no=no;
    }

}
