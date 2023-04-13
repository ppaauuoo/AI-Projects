/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.idsia.agents;

import ch.idsia.benchmark.mario.engine.sprites.Mario;
import ch.idsia.benchmark.mario.environments.Environment;
import ch.idsia.agents.controllers.BasicMarioAIAgent;
import ch.idsia.agents.QlearningAgent.QLearning;
import ch.idsia.benchmark.mario.engine.GeneralizerLevelScene;
import ch.idsia.benchmark.mario.engine.sprites.Sprite;
//import java.util.ArrayList;
//import java.util.List;

import java.util.*;

/**
 *
 * @author Teslar
 */
public class Qlearning_Agent extends BasicMarioAIAgent implements Agent {

    protected boolean Action[] = new boolean[Environment.numberOfKeys];
    protected String Name = "Q-Agent";
    int trueJumpCounter = 0;
    int trueSpeedCounter = 0;
    QLearning QL;
    float previousPosX = 32.0f;
    float previousPosY = 0;
    int previousMode = 2;
    int prevprevAction = 0;
    int prevAction = 0;
    boolean previsOnground = false;
    boolean prevJump = false;
    boolean[] prevAction_ = new boolean[Environment.numberOfKeys];
    public boolean isTestRound = false;

    public Qlearning_Agent(String s, QLearning Q) {
        super(s);
        this.QL = Q;
        reset();
    }

    public Qlearning_Agent(String s, QLearning Q, boolean istest) {
        super(s);
        this.QL = Q;
        isTestRound = istest;
        reset();
    }

    public Qlearning_Agent(String s) {
        super(s);
        QL = new QLearning();
        reset();
    }

    public void reset() {
        Action = new boolean[Environment.numberOfKeys];
        previousPosX = 32.0f;
        previousPosY = 0;
        previousMode = 2;
        prevprevAction = 0;
        prevAction = 0;
        previsOnground = false;
        prevJump = false;
        QL.resetGame();
        prevCoin = 0;
    }

    float weightDeath = -100f;
    float weightDamage = -50f;
    float weightDistance = 2f;
    float weightPressBtn = 0f;
    float weightCoin = 20f;
//    float weightwin = 1000f;
    int prevCoin = 0;

    public boolean[] getAction() {
//        printLevel(super.levelScene);
//        ArrayList<Integer> listA = new ArrayList<Integer>();
//        clearScreen();
        byte[][] scenetrimmed = trim(mergedObservation, 9, marioEgoCol, marioEgoRow);
        reduction(scenetrimmed);

//        System.out.println("prev Pos = " + previousPosX );
//        System.out.println("Current Pos = " + marioFloatPos[0] );
//        System.out.println("mario pos:" + (marioFloatPos[0] - previousPosX));
//        System.out.println("mario mode:" +(marioMode));
//        System.out.println("mario mode Reduct:" + ( marioMode >= 1 ? 1 : marioMode));      
//        System.out.println("mario status:" + marioStatus);
//        System.out.println("Death?:" +(marioStatus != 0? 0:1));
//        float reward = (((marioFloatPos[0] - previousPosX) == 0 ? -5f : (marioFloatPos[0] - previousPosX)) * weightDistance)
        float reward = ((marioFloatPos[0] - previousPosX) * weightDistance)
                + ((previousMode - marioMode) * weightDamage)
                + ((marioStatus != 0 ? 0 : 1) * weightDeath)
                + ((prevAction == prevprevAction ? 0f : 1f) * weightPressBtn)
//                + ((coingain - prevCoin) * weightCoin) 
                ;
//                if(prevCoin != coingain){
//                System.out.println("coingain = " + (coingain-prevCoin));
//                }

//        System.out.println("reward = " + reward);
//        if(prevAction == 1){
//        System.out.println("Difference Pos : " + (marioFloatPos[0] - previousPosX));
//        if (previousMode - marioMode != 0){
//        System.out.println("Dif Mode = " + (previousMode - marioMode));
//        }
//        System.out.println("reward = " + reward);
//        System.out.println("----------------------");
//        }
        /*-------------update prev-------------------*/
        previousPosX = marioFloatPos[0];
        previousMode = marioMode;
        prevCoin = coingain;
        /*reduce data*/
//        System.out.println("mario mode = " + marioMode);
//        System.out.println("mario Status = " + marioStatus);
        int marioMode_reducted = marioMode >= 1 ? 1 : marioMode;
//        int marioMode_reducted = marioMode;

//        printLevel(scenetrimmed,marioMode_reducted, isMarioOnGround);
//        QL.setNextState(scenetrimmed, marioMode, previsOnground);
        int tmpAction = 0;
        if (!isTestRound) {
            if (QL.isCurStateExist()) {
                QL.updateQ(reward, scenetrimmed, marioMode_reducted, isMarioOnGround);// 20181023
            }
//        System.out.println("-------------update-end----------");
//        int tmpAction = QL.getAction(scenetrimmed, marioMode_reducted, isMarioOnGround);
            tmpAction = QL.getActionWithEpsilonGreedy(scenetrimmed, marioMode_reducted, isMarioOnGround);// 20181019
        } else {
            tmpAction = QL.getAction(scenetrimmed, marioMode_reducted, isMarioOnGround);
            if (prevJump == true && (previousPosY - marioFloatPos[1] == 0)) {
                prevJump = false;
                previsOnground = isMarioOnGround;
                prevprevAction = prevAction;
                prevAction = 0;
                previousPosY = marioFloatPos[1];
                return new boolean[]{false, false, false, false, false, false};

            }
        }

        
        prevJump = false;
        Action = Int2Action(tmpAction);
        prevprevAction = prevAction;
        prevAction = tmpAction;
        previsOnground = isMarioOnGround;
        previousPosY = marioFloatPos[1];
        return Action;
    }

    
    /*-------------------------------Utility Function-----------------------------*/

    public byte[][] trim(byte[][] scene, int size, int centerX, int centerY) {
        byte[][] trimed = new byte[size][size];
        int halfSize = size / 2;
        int n = 0;

        for (int j = centerY - halfSize; j < centerY + halfSize + 1; j++) {
            int m = 0;
            for (int i = centerX - halfSize; i < centerX + halfSize + 1; i++) {
                trimed[n][m] = scene[j][i];
                m++;
            }
            n++;
        }
        return trimed;
    }

    public void reduction(byte[][] s) {
        for (int j = 0; j < s.length; j++) {
            for (int i = 0; i < s[j].length; i++) {
                if (s[j][i] == GeneralizerLevelScene.BORDER_CANNOT_PASS_THROUGH
                        || s[j][i] == GeneralizerLevelScene.UNBREAKABLE_BRICK
                        || s[j][i] == GeneralizerLevelScene.BREAKABLE_BRICK
                        || s[j][i] == GeneralizerLevelScene.CANNON_MUZZLE
                        //                        || s[j][i] == GeneralizerLevelScene.COIN_ANIM
                        || s[j][i] == GeneralizerLevelScene.CANNON_TRUNK
                        || s[j][i] == GeneralizerLevelScene.FLOWER_POT
                        || s[j][i] == GeneralizerLevelScene.FLOWER_POT_OR_CANNON) {
                    s[j][i] = 2;
                } else if (s[j][i] == GeneralizerLevelScene.BORDER_HILL //                        
                        ) {
                    s[j][i] = 3;
                } else if (s[j][i] == 80 || s[j][i] == 95
                        || s[j][i] == 82 || s[j][i] == 97
                        || s[j][i] == 81 || s[j][i] == 96
                        || s[j][i] == 84 || s[j][i] == 98
                        || s[j][i] == 13) {
                    s[j][i] = 4;
                } else if (s[j][i] == 93
                        || s[j][i] == 99
                        || s[j][i] == 91) {
                    s[j][i] = 5;

//                } else if (s[j][i] == Sprite.KIND_MUSHROOM ||
//                        s[j][i] == GeneralizerLevelScene.COIN_ANIM|| 
//                        s[j][i] == Sprite.KIND_FIRE_FLOWER) {
//                    s[j][i] = 7;
//                } else if (s[j][i] == GeneralizerLevelScene.COIN_ANIM) {
//                    s[j][i] = 6;
//                } else if (s[j][i] == Sprite.KIND_MUSHROOM
//                        || s[j][i] == Sprite.KIND_FIRE_FLOWER) {
//                    s[j][i] = 7;
//                } else if (s[j][i] == Sprite.KIND_MUSHROOM) {
//                    s[j][i] = 7;
//                } else if (s[j][i] == Sprite.KIND_FIRE_FLOWER) {
//                    s[j][i] = 8;

                } else {
                    s[j][i] = 1;
                }

            }
        }

    }

    public boolean[] Int2Action(int act_int) {
        /*
        public static final int KEY_LEFT = 0;
        public static final int KEY_RIGHT = 1;
        public static final int KEY_DOWN = 2;
        public static final int KEY_JUMP = 3;
        public static final int KEY_SPEED = 4;
        public static final int KEY_UP = 5;
         */

        switch (act_int) {
            default:
                /*Left   Right Down   Jump   SPD    Up */
                prevJump = false;
                return new boolean[]{false, false, false, false, false, false};
            case 0:
                prevJump = false;
                return new boolean[]{false, false, false, false, false, false}; // stay
            case 1:
                prevJump = false;
                return new boolean[]{false, false, true, false, false, false};  //crouch
            case 2:
                prevJump = false;
                return new boolean[]{false, true, false, false, false, false};  //Right walk
            case 3:
                prevJump = false;
                return new boolean[]{false, true, false, false, true, false};   //Right Run
            case 4:
                prevJump = false;
                return new boolean[]{true, false, false, false, false, false};  //Left walk
            case 5:
                prevJump = false;
                return new boolean[]{true, false, false, false, true, false};   //Left Run
            /*-------------------------------Jump------------------------------------------*/
            case 6:
                prevJump = true;
                return new boolean[]{false, true, false, true, false, false};   //Right Jump
            case 7:
                prevJump = true;
                return new boolean[]{false, true, false, true, true, false};    //Right Run Jump
            case 8:
                prevJump = true;
                return new boolean[]{true, false, false, true, false, false};   //Left jump
            case 9:
                prevJump = true;
                return new boolean[]{true, false, false, true, true, false};    //Left Run jump
            case 10:
                prevJump = true;
                return new boolean[]{false, false, false, true, false, false};  //Jump

        }
//        zreturn new boolean[]{false, false, false, false, false, false};
    }

    public void printLevel(byte[][] levelScene, int state, boolean isOnground) {
        System.out.println("mario state: " + state + " , mario on ground :" + isOnground);
        System.out.print(marioEgoRow + ", " + marioEgoCol + "\t\t");
        for (int i = 0; i < levelScene[0].length; i++) {
            System.out.print(i + "\t");
        }
        System.out.println();
        System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------------");
        for (int j = 0; j < levelScene.length; j++) {
            System.out.print(j + "\t|" + "\t");
            for (int i = 0; i < levelScene[j].length; i++) {
                System.out.print(levelScene[j][i] + "\t");
            }
            System.out.println("");
        }
        System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------------");
    }
    /*--------------------------Utility Function end------------------------------*/
}
