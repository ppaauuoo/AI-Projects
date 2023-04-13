/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ai2313.work11223;

/**
 *
 * @author opo25
 */
public class Products {
    Product [] pds = new Product[10];
    private int index=0;
    
    public void setPD(Product pd){
      pds[index++]=pd; 
    }
    
    public Product[] getPD(){
        return pds;
    }
    
    public String getName(int index){
        return pds[index].getName();
    }
    
    public int getIndex(){
        return index;
    }
    
    public double getCost(int index){
        return pds[index].getCost();
    }

}
