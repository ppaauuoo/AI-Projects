package ch.idsia.agents.QlearningAgent;

import java.util.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.io.*;
import ch.idsia.utils.wox.serial.Easy;

/**
 *
 * @author TEMSIRIRIRKKUL SILA
 */
public class QLearning {

    float gamma = 0.9f;
    float alpha = 0.01f;
    float initialAlpha = 0.01f;
    float epsilon = 0.0125f;
    Random r = new Random();
    state CurrentState;
    int current_MState;
    boolean current_OnGround;
    state NextState;
    int CurrentAction;
//    List<state> stateList;
    Map<String, state> hashStateList;
    
    public QLearning(float alpha, float gamma, float epsilon) {
        this.alpha = alpha;
        this.gamma = gamma;
        this.epsilon = epsilon;
//        stateList = new ArrayList<state>();
        hashStateList = new HashMap<>();
    }
    
    public int getAlpha(){
        return (int)(alpha * 1000f);
    }
    public int getinitAlpha(){
        return (int)(initialAlpha * 1000f);
    }
    
    public QLearning() {
//        stateList = new ArrayList<state>();
        hashStateList = new HashMap<>();
        initialAlpha= alpha;
    }

    public QLearning(String s) {
        QLoad(s);
    }

    public void resetGame() {
        this.NextState = null;
        this.CurrentState = null;
        this.CurrentAction = 0;
    }

    public boolean isCurStateExist() {
        return CurrentState != null;
    }

    public int getRndAction(List<Integer> possibleAction) {
//        int maxLength = possibleAction.size();
        return possibleAction.get(r.nextInt(possibleAction.size()));
    }

    private int randActionExcept(int x) {
        int rndN = x;
        while (rndN == x) {
            rndN = r.nextInt(11);
        }
        return rndN;
    }

    private state getState(byte[][] CurrentScene, int marioMode, boolean isOnground) {
        String key = byteArrayToString(CurrentScene);
        
        if((!hashStateList.isEmpty()) && hashStateList.containsKey(key)){
            return hashStateList.get(key);
        }
        state newState = new state(key);
        hashStateList.put(key, newState);
        return newState;
    }
/*-------------------------------------getActoin without greedy-------------------------------------------*/
    public int getAction(byte[][] CurrentScene, int marioMode, boolean isOnground) {
        this.CurrentState = getState(CurrentScene, marioMode, isOnground);
        this.current_MState = marioMode;
        this.current_OnGround = isOnground;
//        System.out.println("State Number:" + stateList.size());
        int Action;
//        this.CurrentState.printQ(marioMode, isOnground);
        List<Integer> MaxQActions;
        /*--------------Find Max Q Acton----------------- */
        MaxQActions = this.CurrentState.getMaxQActionList(marioMode, isOnground);
        /*-------------------------------------------------*/
        if (MaxQActions.size() > 1) {
            Action = getRndAction(MaxQActions);
        } else {
            Action = MaxQActions.get(0);
        }
//        System.out.println("maxQ:" + Action);
        return Action;
    }
/*---------------------------------end getActoin without greedy-------------------------------------------*/
    
    public int getNumberofState() {
        return hashStateList.size();
    }

    /*-------------------------------------getActoin with greedy-------------------------------------------*/
    public int getActionWithEpsilonGreedy(byte[][] CurrentScene, int marioMode, boolean isOnground) {
        this.CurrentState = getState(CurrentScene, marioMode, isOnground);
//        System.out.println("State Number:" + stateList.size());
        this.current_MState = marioMode;
        this.current_OnGround = isOnground;
        int Action;
        List<Integer> MaxQActions;
        
//        this.CurrentState.printQ(marioMode, isOnground);
        
        /*--------------Find Max Q Acton----------------- */
        MaxQActions = this.CurrentState.getMaxQActionList(marioMode, isOnground);
//        
//        System.out.print("MaxQActionList = {");
//        for(int action: MaxQActions){
//            System.out.print(action + ",");
//        }
//        System.out.println("} withMaxQ = " + this.CurrentState.getMaxQ(marioMode, isOnground) );
        /*-------------------------------------------------*/
        if (MaxQActions.size() > 1) {
            Action = getRndAction(MaxQActions);
        } else {
            Action = MaxQActions.get(0);
        }
        
//        System.out.println("Choosen action =" + Action);
        
        /*----------episilon greedy-----------------*/
        double rndN = r.nextDouble();
        if (rndN <= epsilon) {
            Action = randActionExcept(Action);
        }
        CurrentAction = Action;
        
//        System.out.println("Selected Action(include Epsilon Greedy):" + Action);
//        System.out.println("--------------------------------------------------------");
        
        return Action;
        /*---------------end------------------------*/
    }

    /*-----------------------------------end getActoin with greedy-----------------------------------------*/
    public void updateQ(float currentReward, byte[][] NextScene, int marioMode, boolean isOnground) {
        NextState = getState(NextScene, marioMode, isOnground);
        
        float reward = ((1 - alpha) * this.CurrentState.getQ(this.current_MState, this.current_OnGround, CurrentAction)) + (alpha * (currentReward + (gamma * this.NextState.getMaxQ(marioMode, isOnground))));
        
//        if(CurrentAction == 1 && currentReward > 0){
//        NextState.printQ(marioMode, isOnground);
//        System.out.println("Max Q = \t" + this.NextState.getMaxQ(marioMode, isOnground));
//        System.out.println("Reward :\t" + currentReward);
//        System.out.println("new Q : \t" + reward);
//        }
        
        this.CurrentState.UpdateQ(this.current_MState, this.current_OnGround, CurrentAction, reward);
        
//        if(CurrentAction == 1 && currentReward > 0){
//        this.CurrentState.printQ(this.current_MState, this.current_OnGround);
//        }
        NextState = null;
    }


    public void alphaUpdate(int episode) {
        this.alpha = initialAlpha * (500000f / (500000f + (episode)));
        System.out.println("Current Alpha = " + this.alpha);
    }

    public void Qsave(String s) {
        List<state> stateList = new ArrayList<state>();
        for(state a : this.hashStateList.values()){
            stateList.add(a);
        }
        Easy.save(stateList, s);
    }

    public void QLoad(String s) {
        List<state> stateList = (ArrayList) Easy.load(s);
        for(state a : stateList)
        {
            this.hashStateList.put(a.getState(), a);
        }
    }
    public String byteArrayToString(byte[][] input){
        String output ="";
        for(byte[] a : input){
            for(byte b: a)
            output += b;
        }
        return output;
    }
}
