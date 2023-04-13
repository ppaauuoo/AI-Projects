/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.idsia.scenarios;

import ch.idsia.agents.Agent;
import ch.idsia.agents.QlearningAgent.QLearning;
import ch.idsia.agents.Qlearning_Agent;

import ch.idsia.benchmark.mario.environments.Environment;
import ch.idsia.benchmark.tasks.BasicTask;
import ch.idsia.tools.MarioAIOptions;

import ch.idsia.benchmark.tasks.QLearningTask;
import ch.idsia.benchmark.mario.engine.GlobalOptions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
//import java.io.PrintWriter;
//import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.LinkedList;

//import java.time.*;
import java.util.Date;
import java.util.Calendar;
import java.text.SimpleDateFormat;
import java.util.Random;



import com.opencsv.CSVWriter;

import ch.idsia.utils.wox.serial.Easy;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author Teslar
 */
public class TestQPlay {

    public static void main(String[] args) throws IOException {
        int round = 1000000;
        int round_start = 1;
        long startTime = System.currentTimeMillis();
        Random rnd = new Random();
        String time_ = (new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime()));

//        final String argsString = "-le off";
//        final String argsString = "-fps 100";
//        final String argsString = "-gv on -fps 100";
//        final MarioAIOptions marioAIOptions = new MarioAIOptions(argsString);
//        marioAIOptions.setVisualization(false);
        final MarioAIOptions marioAIOptions = new MarioAIOptions(args);
        QLearning QL = new QLearning();
        
        Agent agent = new Qlearning_Agent("Q", QL);
        Agent tester = new Qlearning_Agent("Q_Test", QL, true);
//        QL.QLoad("MaxScoreQ_1.XML");
//        QL.QLoad("QTableFinal.XML");
//        QL.QLoad("QTable_itteration_18900.XML");

        marioAIOptions.setAgent(agent);
        marioAIOptions.setReceptiveFieldHeight(18);
        marioAIOptions.setReceptiveFieldWidth(18);
        marioAIOptions.setVisualization(false);
        marioAIOptions.setLevelDifficulty(0);
//        marioAIOptions.setFPS(100);

//        final BasicTask basicTask = new BasicTask(marioAIOptions);
        final QLearningTask QTask = new QLearningTask(marioAIOptions);
        GlobalOptions.changeScale2x();
//        GlobalOptions.FPS = 100;

        int winCount = 0;
        /*--------------visualize setting --------------*/
        boolean visualizeNeed = false;
        int visualizeIteration = 1;
        boolean setVisualization = false;
        int saveIteration = 100000;
        /*----------------------------------------------*/

        int temp_Result = 0;
//        int average_every_ = 1000;
        int testRound = 1000;
        int temp_test_Result = 0;
        int temp_coin = 0;
        int maxEvaluate = 0;

        List<String[]> result_avgFit = new LinkedList<String[]>();
        List<String[]> result_TestScr = new LinkedList<String[]>();
        List<String[]> stateNum = new LinkedList<String[]>();

        int score;
//        for (int i = 0 + round_start; i <= round; ++i) {
//            System.out.println("実行回数： " + i);
//            marioAIOptions.setAgent(tester);
//            QTask.setOptionsAndReset(marioAIOptions);
//            QTask.runSingleEpisode(1);
//            System.out.println(QTask.getEnvironment().getEvaluationInfoAsString());
//            QTask.setOptionsAndReset(marioAIOptions);
//            QL.resetGame();
//        }
        
        
        for (int i = 0 + round_start; i <= round; ++i) {

            marioAIOptions.setLevelRandSeed(i%5);
            System.out.println("実行回数： " + i);
            QTask.runSingleEpisode(1);
            System.out.println(QTask.getEnvironment().getEvaluationInfoAsString());
            QTask.setOptionsAndReset(marioAIOptions);
            QL.resetGame();
            score = QTask.getEvaluatioScore();
            System.out.println(score);

//            temp_Result += score;
            if (i % testRound == 0) {
                marioAIOptions.setLevelRandSeed(rnd.nextInt(5));
                marioAIOptions.setAgent(tester);
                if (i % visualizeIteration == 0 && visualizeNeed) {
                    marioAIOptions.setVisualization(true);
                    QTask.setOptionsAndReset(marioAIOptions);
                    setVisualization = true;
                } else {
                    QTask.setOptionsAndReset(marioAIOptions);
                }
                QTask.runSingleEpisode(1);
                System.out.println("------*****test*****--------");
                System.out.println(QTask.getEnvironment().getEvaluationInfoAsString());
                QTask.setOptionsAndReset(marioAIOptions);
                QL.resetGame();
                float Distance = QTask.getMovedDistance();
                score = QTask.getEvaluatioScore();
                temp_coin += QTask.getEvaluationInfo().coinsGained;
                System.out.println("test score = " + score);
                System.out.println("Distance = " + Distance);
                temp_test_Result = score;
//                temp_Result += score;
                result_TestScr.add(new String[]{Integer.toString(temp_test_Result), Float.toString(Distance), Integer.toString(QTask.getEvaluationInfo().coinsGained)});
                marioAIOptions.setAgent(agent);
                QTask.setOptionsAndReset(marioAIOptions);

                if (score > maxEvaluate && score >= 6000) {
                    maxEvaluate = score;
                    QL.Qsave(time_ + "MaxScoreQ.XML");
                }

            }

//            if (i % average_every_ == 0) {
//                float avg = temp_Result / average_every_;
//                float avg_coin = temp_coin / average_every_;
//                result_avgFit.add(new String[]{Float.toString(avg),Float.toString(avg_coin)});
//                temp_Result = 0;
//                temp_coin = 0;
//            }
            System.out.println("-------------------------------------------------------");
            QL.alphaUpdate(i);
            System.out.println("State num : " + QL.getNumberofState());
            stateNum.add(new String[]{Integer.toString(QL.getNumberofState())});
            if (i % saveIteration == 0) {
                QL.Qsave(time_ + "_QTable_itteration_" + i + ".XML");
            }
            if (setVisualization == true) {
                marioAIOptions.setVisualization(false);
                QTask.setOptionsAndReset(marioAIOptions);
                setVisualization = false;
            }

        }
        long stopTime = System.currentTimeMillis();
        long elapsedTime = stopTime - startTime;
//        System.out.println("Winning ratio : " + (winCount / round));
        System.out.println("Experiment time : " + String.format("%02d:%02d:%02d", TimeUnit.MILLISECONDS.toHours(elapsedTime),
            TimeUnit.MILLISECONDS.toMinutes(elapsedTime) - TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(elapsedTime)),
            TimeUnit.MILLISECONDS.toSeconds(elapsedTime) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(elapsedTime))));

        QL.Qsave(time_ + "_QTableFinal.XML");

        /*------------------write CSV file--------------------------------------------*/
//        String ResulaDataOutputnameaverageFit = "QTabelResult_" + time_+"_InitAlpha"+ QL.getinitAlpha() + "_to" + QL.getAlpha() + "_avgFit.csv";
        String ResulaDataOutputnameTestScore = "QTabelResult_" + time_ + "_InitAlpha" + QL.getinitAlpha() + "_to" + QL.getAlpha() + "_TestScoreFit.csv";
        String ResulaDataOutputnameStateNum = "QTabelResult_" + time_ + "_InitAlpha" + QL.getinitAlpha() + "_to" + QL.getAlpha() + "_StateNum.csv";
//        CSVWriter csvWriter_avgFit = new CSVWriter(new FileWriter(ResulaDataOutputnameaverageFit));
        CSVWriter csvWriter_testScore = new CSVWriter(new FileWriter(ResulaDataOutputnameTestScore));
        CSVWriter csvWriter_StateNum = new CSVWriter(new FileWriter(ResulaDataOutputnameStateNum));
//        csvWriter_avgFit.writeAll(result_avgFit);
//        csvWriter_avgFit.close();
        result_TestScr.add(new String[]{"ExperimentTime = " + String.format("%02d:%02d:%02d", TimeUnit.MILLISECONDS.toHours(elapsedTime),
            TimeUnit.MILLISECONDS.toMinutes(elapsedTime) - TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(elapsedTime)),
            TimeUnit.MILLISECONDS.toSeconds(elapsedTime) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(elapsedTime)))});
        
        csvWriter_testScore.writeAll(result_TestScr);
        csvWriter_testScore.close();
        csvWriter_StateNum.writeAll(stateNum);
        csvWriter_StateNum.close();
        /*----------------------------------------------------------------------------*/
        System.exit(0);
    }

}
