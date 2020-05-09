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

    private Circle[] circles;

    public void render(Circle[] circles) {
        this.circles = circles;
        this.repaint();
    }

    public int getCanvasWidth() {
        return canvasWidth;
    }

    public int getCanvasHeight() {
        return canvasHeight;
    }

    private class AlgoCanvas extends JPanel {

        public AlgoCanvas() {
            super(true);
        }


        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            // 将Graphic对象转换为Graphic2D对象
            Graphics2D g2d = (Graphics2D) g;
            // 开启抗锯齿
            RenderingHints hints = new RenderingHints(RenderingHints.KEY_ANTIALIASING,
                    RenderingHints.VALUE_ANTIALIAS_ON);
            g2d.addRenderingHints(hints);
            // 具体绘制
            AlgoVisHelper.setStrokeWidth(g2d, 1);
            AlgoVisHelper.setColor(g2d, Color.RED);
            for (Circle circle : circles) {
                AlgoVisHelper.drawCircle(g2d, circle.x, circle.y, circle.getR());
            }
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(canvasWidth, canvasHeight);
        }
    }
}
