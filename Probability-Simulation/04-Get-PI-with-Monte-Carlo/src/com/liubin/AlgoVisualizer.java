package com.liubin;

import java.awt.*;
import java.util.LinkedList;


/**
 * @ClassName AlgoVisualizer
 * @Description: 算法可视化控制层
 * @Author liubin
 * @Date 2020/5/11 0011
 * @Version V1.0
 **/
public class AlgoVisualizer {

    //  创建自己的数据
    private MonteCarloPiData data;
    private int N; // 打点数量

    private AlgoFrame frame; // 视图

    public AlgoVisualizer(String title, int sceneWidth, int sceneHeight, int N) {
        // 初始化数据
        Circle circle = new Circle(sceneWidth / 2, sceneHeight / 2, sceneWidth / 2);
        data = new MonteCarloPiData(circle);
        this.N = N;
        // 初始化视图
        EventQueue.invokeLater(() -> {
            frame = new AlgoFrame(title, sceneWidth, sceneHeight);
            new Thread(this::run).start();
        });
    }

    private void run() {
        // 编写自己的动画逻辑
        for (int i = 0; i < N; i++) {
            if ( i % 100 == 0) {
                frame.render(data);
                AlgoVisHelper.pause(40);
                System.out.println(data.estimatePi());
            }
            int x = (int)(Math.random() * frame.getCanvasWidth());
            int y = (int)(Math.random() * frame.getCanvasHeight());

            Point p = new Point(x, y);
            data.addPoint(p);
        }
    }


    public static void main(String[] args) {
        AlgoVisualizer visualizer = new AlgoVisualizer("Get-PI-with-Monte-Carlo", 800, 800, 10000);
    }
}
