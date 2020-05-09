package com.liubin;

import java.awt.*;

/**
 * @ClassName Main
 * @Description: TODO
 * @Author liubin
 * @Date 2020/5/9 0009
 * @Version V1.0
 **/
public class Main {
    public static void main(String[] args) {
        int sceneWidth = 800;
        int sceneHeight = 800;

        int N = 10;
        Circle[] circles = new Circle[N];
        int R = 50;
        for (int i = 0; i < N; i++) {
            int x = (int) (Math.random() * (sceneWidth - 2 * R)) + R;
            int y = (int) (Math.random() * (sceneHeight - 2 * R)) + R;
            int vx = (int) (Math.random() * 11) - 5;
            int vy = (int) (Math.random() * 11) - 5;
            circles[i] = new Circle(x, y, R, vx, vy);
        }

        EventQueue.invokeLater(() -> {
            AlgoFrame algoFrame = new AlgoFrame("Welcome", sceneWidth, sceneHeight);
            new Thread(() -> {
                while (true) {
                    // 绘制数据
                    algoFrame.render(circles);
                    AlgoVisHelper.pause(20);
                    // 更新数据
                    for (Circle circle : circles) {
                        circle.move();
                    }
                }
            }).start();

        });
    }
}
