package com.liubin;

import javax.swing.*;
import java.awt.*;

/**
 * @ClassName AlgoFrame
 * @Description: TODO
 * @Author liubin
 * @Date 2020/5/9 0009
 * @Version V1.0
 **/
public class AlgoFrame extends JFrame {

    private int canvasWidth;

    private int canvasHeight;

    public AlgoFrame(String title, int canvasWidth, int canvasHeight) {
        super(title);
        this.canvasWidth = canvasWidth;
        this.canvasHeight = canvasHeight;
        // 使用画布
        AlgoCanvas canvas = new AlgoCanvas();
        // 设置画布大小
        canvas.setPreferredSize(new Dimension(canvasWidth, canvasHeight));
        // 设置内容面板
        this.setContentPane(canvas);
        // 调用pack方法调整窗口大小
        pack();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public AlgoFrame(String title) {
        this(title, 1024, 768);
    }

    public int getCanvasWidth() {
        return canvasWidth;
    }

    public int getCanvasHeight() {
        return canvasHeight;
    }

    private class AlgoCanvas extends JPanel {

        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawOval(50, 50, 300, 300);
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(canvasWidth, canvasHeight);
        }
    }
}
