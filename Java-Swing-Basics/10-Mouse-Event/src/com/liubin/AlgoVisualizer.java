package com.liubin;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

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

    private boolean isAnimated = true;

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
            algoFrame.addKeyListener(new AlgoKeyListener());
            algoFrame.addMouseListener(new AlgoMouseListener());
            new Thread(this::run).start();

        });
    }

    private void run() {
        while (true) {
            // 绘制数据
            algoFrame.render(circles);
            AlgoVisHelper.pause(20);
            // 更新数据
            if (isAnimated) {
                for (Circle circle : circles) {
                    circle.move(0, 0, algoFrame.getCanvasWidth(), algoFrame.getCanvasHeight());
                }
            }
        }
    }

    private class AlgoKeyListener extends KeyAdapter {

        @Override
        public void keyReleased(KeyEvent e) {
            if (e.getKeyChar() == ' ') {
                isAnimated = !isAnimated;
            }
        }
    }

    private class AlgoMouseListener extends MouseAdapter {

        @Override
        public void mousePressed(MouseEvent e) {
            e.translatePoint(0,
                    -(algoFrame.getBounds().height - algoFrame.getCanvasHeight()));
//            System.out.println(e.getPoint());
            for (Circle circle : circles) {
                if (circle.contains(e.getPoint())) {
                    circle.isFilled = !circle.isFilled;
                }
            }
        }
    }

    public static void main(String[] args) {
        int sceneWidth = 800;
        int sceneHeight = 800;
        int N = 10;
        AlgoVisualizer visualizer = new AlgoVisualizer(sceneWidth, sceneHeight, N);
    }
}
