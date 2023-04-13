/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ai2313.inheritance640586;

/**
 *
 * @author opo25
 */
public class CalculateSalary {
    CalculateSalary(){}
    int pindex=0;
    int findex=0;
    int mindex=0;
    int oindex=0;
    
    public PartTime [] pt =new PartTime[10];
    public FullTime [] ft =new FullTime[10];
    public Manager [] mg =new Manager[10];
    public Operator [] op =new Operator[10];
    
    public void setPT(PartTime pt){
        this.pt[pindex++]=pt;
    }
    public void setFT(FullTime ft){
        this.ft[findex++]=ft;
    }
    public void setMG(Manager mg){
        this.mg[mindex++]=mg;
    }
    public void setOP(Operator op){
        this.op[oindex++]=op;
    }
 
    public PartTime [] getPT(){
        return pt;
    }
    public FullTime [] getFT(){
        return ft;
    }
    public Manager [] getMG(){
        return mg;
    }
    public Operator [ ] getOP(){
        return op;
    }
    
    
    public double getBooth(double tday){
        int temp=0;
        if(tday%1>0){
            temp+=200;  
        }
        temp+=(int)tday*500;
        return temp;
    }
    
    public double getCommission(double tsale){
        if(tsale>600000){
            return tsale*8/100;
        }else if(tsale>300000){
            return tsale*7/100;
        }else if(tsale>50000){
            return tsale*6/100;
        }else if(tsale>5000){
            return tsale*5/100;
        }else{
            return 0;
        }
    }
        
        public double getBonus(double tyear,double salary){
        if(tyear>5){
            return salary*=3;
        }else if(tyear>3){
            return salary*=2;
        }else if(tyear>1){
            return salary*=1;
        }else if(tyear>0){
            return salary*=0.5;
        }else{
            return 0;
        }
    }
    
}
