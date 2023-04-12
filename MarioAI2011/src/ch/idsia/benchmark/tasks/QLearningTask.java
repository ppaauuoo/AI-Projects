/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.idsia.benchmark.tasks;

import ch.idsia.agents.Agent;
import ch.idsia.benchmark.mario.engine.GlobalOptions;
import ch.idsia.benchmark.mario.environments.Environment;
import ch.idsia.benchmark.mario.environments.MarioEnvironment;
import ch.idsia.tools.EvaluationInfo;
import ch.idsia.tools.MarioAIOptions;
import ch.idsia.utils.statistics.StatisticalSummary;
import java.util.Vector;

/**
 *
 * @author Teslar
 */
public class QLearningTask implements Task{
    protected final static Environment environment = MarioEnvironment.getInstance();
private Agent agent;
protected MarioAIOptions options;
private long COMPUTATION_TIME_BOUND = 42; // stands for prescribed  FPS 24.
private String name = getClass().getSimpleName();
private EvaluationInfo evaluationInfo;

private Vector<StatisticalSummary> statistics = new Vector<StatisticalSummary>();

public QLearningTask(MarioAIOptions marioAIOptions)
{
    this.setOptionsAndReset(marioAIOptions);
}

/**
 * @param repetitionsOfSingleEpisode
 * @return boolean flag whether controller is disqualified or not
 */

public int getEvaluatioScore(){
    return evaluationInfo.computeWeightedFitness();
}

public float getMovedDistance(){
    return (float)evaluationInfo.distancePassedPhys;
}

public boolean runSingleEpisode(final int repetitionsOfSingleEpisode)
{
    long c = System.currentTimeMillis();
    for (int r = 0; r < repetitionsOfSingleEpisode; ++r)
    {
        this.reset();
        while (!environment.isLevelFinished())
        {
            environment.tick();
            if (!GlobalOptions.isGameplayStopped)
            {
                c = System.currentTimeMillis();
                agent.integrateObservation(environment);
                agent.giveIntermediateReward(environment.getIntermediateReward());

                boolean[] action = agent.getAction();
//                if (System.currentTimeMillis() - c > COMPUTATION_TIME_BOUND){
//                    System.out.println("Calculation Time Over");
////                    environment.getEvaluationInfo().Memo = "calculationTimeOver";
//                    return false;
//                }
//                System.out.println("action = " + Arrays.toString(action));
//            environment.setRecording(GlobalOptions.isRecording);
                environment.performAction(action);
            }
        }
//        System.out.println("level Finished? " + environment.isLevelFinished());
        environment.closeRecorder(); //recorder initialized in environment.reset
        environment.getEvaluationInfo().setTaskName(name);
        this.evaluationInfo = environment.getEvaluationInfo().clone();
    }

    return true;
}

public Environment getEnvironment()
{
    return environment;
}

public int evaluate(Agent controller)
{
    return 0;
}

public void setOptionsAndReset(MarioAIOptions options)
{
    this.options = options;
    reset();
}

public void setOptionsAndReset(final String options)
{
    this.options.setArgs(options);
    reset();
}

public void doEpisodes(int amount, boolean verbose, final int repetitionsOfSingleEpisode)
{
    for (int j = 0; j < EvaluationInfo.numberOfElements; j++)
    {
        statistics.addElement(new StatisticalSummary());
    }
    for (int i = 0; i < amount; ++i)
    {
        this.reset();
        this.runSingleEpisode(repetitionsOfSingleEpisode);
        if (verbose)
            System.out.println(environment.getEvaluationInfoAsString());

        for (int j = 0; j < EvaluationInfo.numberOfElements; j++)
        {
            statistics.get(j).add(environment.getEvaluationInfoAsInts()[j]);
        }
    }

    System.out.println(statistics.get(3).toString());
}

public boolean isFinished()
{
    return false;
}

public void reset()
{
    agent = options.getAgent();
    environment.reset(options);
    agent.reset();
    agent.setObservationDetails(environment.getReceptiveFieldWidth(),
            environment.getReceptiveFieldHeight(),
            environment.getMarioEgoPos()[0],
            environment.getMarioEgoPos()[1]);
}

public String getName()
{
    return name;
}

public void printStatistics()
{
    System.out.println(evaluationInfo.toString());
}

public EvaluationInfo getEvaluationInfo()
{
//    System.out.println("evaluationInfo = " + evaluationInfo);
    return evaluationInfo;
}

}

