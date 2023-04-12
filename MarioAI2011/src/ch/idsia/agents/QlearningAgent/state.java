/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.idsia.agents.QlearningAgent;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author Teslar
 */
public class state {

    String state;
//    int MarioState;
//    boolean OnGround;
    int size = 9;
    float[][][] QTable;
    float[][] maxQ;
    
    float[][][][] QTable_J;
    float[][][] maxQ_J;
    

    public state(String newstate) {
//        System.out.println("newState");
        this.QTable = new float[2][3][11];                    //No Jumpable State
        this.maxQ = new float[2][3];                          //No Jumpable State
        this.state = newstate;
    }
    public String getState(){
        return state;
    }

    public float getQ(int c_marioState, boolean c_onGround, int action) {
        return QTable[c_onGround ? 1 : 0][c_marioState][action];
    }
   
    public List<Integer> getMaxQActionList(int c_marioState, boolean c_onGround) {
        List<Integer> MaxQActionList = new ArrayList<Integer>();
//        int maxAction = c_onGround ? (isJumpAble? 11:6) : 11;  // if on ground and able to jump = 11 if not able to jump = 6 if not on ground  = 11 
        int maxAction = 11;
        float MQ = -10000000; // set maxQ = first Q in tabel
        for (int i = 0; i < maxAction; i++) {
            if (QTable[c_onGround ? 1 : 0][c_marioState][i] > MQ) {
                MaxQActionList.clear();
                MQ = QTable[c_onGround ? 1 : 0][c_marioState][i];
                MaxQActionList.add(i);
            }else
            if (QTable[c_onGround ? 1 : 0][c_marioState][i] == MQ) {
                MaxQActionList.add(i);
            }
        }
        this.maxQ[c_onGround ? 1 : 0][c_marioState] = MQ;
        return MaxQActionList;
    }

    public void UpdateQ(int c_marioState, boolean c_onGround, int action, float NewQ) {
        QTable[c_onGround ? 1 : 0][c_marioState][action] = NewQ;
    }
    
    public float getMaxQ(int c_marioState, boolean c_onGround) {
        return this.maxQ[c_onGround ? 1 : 0][c_marioState];
    }

    public void printQ(int c_marioState, boolean c_onGround){
        DecimalFormat df = new DecimalFormat("#.##");
        System.out.println("-----------------------Q-----------------------");
        System.out.print(df.format(QTable[c_onGround ? 1 : 0][c_marioState][9]) + "\t");
        System.out.print(df.format(QTable[c_onGround ? 1 : 0][c_marioState][8]) + "\t");
        System.out.print(df.format(QTable[c_onGround ? 1 : 0][c_marioState][10]) + "\t");
        System.out.print(df.format(QTable[c_onGround ? 1 : 0][c_marioState][6]) + "\t");
        System.out.print(df.format(QTable[c_onGround ? 1 : 0][c_marioState][7]) + "\t");
        System.out.println();
        System.out.print(df.format(QTable[c_onGround ? 1 : 0][c_marioState][5]) + "\t");
        System.out.print(df.format(QTable[c_onGround ? 1 : 0][c_marioState][4]) + "\t");
        System.out.print(df.format(QTable[c_onGround ? 1 : 0][c_marioState][0]) + "\t");
        System.out.print(df.format(QTable[c_onGround ? 1 : 0][c_marioState][2]) + "\t");
        System.out.print(df.format(QTable[c_onGround ? 1 : 0][c_marioState][3]) + "\t");
        System.out.println();
        System.out.println("\t\t" + df.format(QTable[c_onGround ? 1 : 0][c_marioState][1]));
        System.out.println("---------------------Q end---------------------");
    }

}
