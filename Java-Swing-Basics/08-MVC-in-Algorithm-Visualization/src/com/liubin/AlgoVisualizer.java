package com.liubin;

import java.awt.*;

/**
 * @ClassName AlgoVisualizer
 * @Description:
 * @Author liubin
 * @Date 2020/5/11 0011
 * @Version V1.0
 **/
public class AlgoVisualizer {

    private Circle[] circles;

    private AlgoFrame algoFrame;

    public AlgoVisualizer(int sceneWidth, int sceneHeight, int N) {
        // 初始化数据
        circles = new Circle[N];
        int R = 50;
        for (int i = 0; i < N; i++) {
            int x = (int) (Math.random() * (sceneWidth - 2 * R)) + R;
            int y = (int) (Math.random() * (sceneHeight - 2 * R)) + R;
            int vx = (int) (Math.random() * 11) - 5;
            int vy = (int) (Math.random() * 11) - 5;
            circles[i] = new Circle(x, y, R, vx, vy);
        }
        // 初始化视图
        EventQueue.invokeLater(() -> {
            algoFrame = new AlgoFrame("Welcome", sceneWidth, sceneHeight);
            new Thread(this::run).start();

        });
    }

    private void run() {
        while (true) {
            // 绘制数据
            algoFrame.render(circles);
            AlgoVisHelper.pause(20);
            // 更新数据
            for (Circle circle : circles) {
                circle.move(0,0, algoFrame.getCanvasWidth(), algoFrame.getCanvasHeight());
            }
        }
    }
}
