package com.liubin;

/**
 * @ClassName ThreeGatesExperiment
 * @Description: 三门问题
 * @Author liubin
 * @Date 2020/5/14 0014
 * @Version V1.0
 **/
public class ThreeGatesExperiment {

    private int N ;

    public ThreeGatesExperiment(int n) {
        N = n;
    }

    public void run(boolean changeDoor) {
        int wins = 0;
        for (int i = 0; i < N; i++) {
            if (play(changeDoor)) {
                wins ++;
            }
        }
        System.out.println(changeDoor ? "Change" : "Not Change");
        System.out.println("winning rate: " + (double)wins/N);
    }

    private boolean play(boolean changeDoor) {
        int prizeDoor = (int) (Math.random() * 3);
        int playerChoice = (int) (Math.random() * 3);

        if (prizeDoor == playerChoice) {
            return !changeDoor;
        } else {
            return changeDoor;
        }
    }

    public static void main(String[] args) {
        int N = 10000000;
        ThreeGatesExperiment experiment = new ThreeGatesExperiment(N);
        experiment.run(true);
        experiment.run(false);
    }
}
