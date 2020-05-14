package com.liubin;

import java.awt.*;

/**
 * @ClassName MonteCarloExperiment
 * @Description:
 * @Author liubin
 * @Date 2020/5/14 0014
 * @Version V1.0
 **/
public class MonteCarloExperiment {

    // 正方形边长
    private int squareSide;
    // 打点数N
    private int N;

    public MonteCarloExperiment(int squareSide, int n) {
        this.squareSide = squareSide;
        N = n;
    }

    public void run() {
        Circle circle = new Circle(squareSide / 2 , squareSide / 2, squareSide / 2);
        MonteCarloPiData data = new MonteCarloPiData(circle);
        for (int i = 0; i < N; i++) {
            int x = (int)(Math.random() * squareSide);
            int y = (int)(Math.random() * squareSide);

            Point p = new Point(x, y);
            data.addPoint(p);
        }
        System.out.println(data.estimatePi());
    }

    public static void main(String[] args) {
        int squareSide = 800;
        int N = 1000000;

        MonteCarloExperiment experiment = new MonteCarloExperiment(squareSide, N);
        experiment.run();
    }
}
