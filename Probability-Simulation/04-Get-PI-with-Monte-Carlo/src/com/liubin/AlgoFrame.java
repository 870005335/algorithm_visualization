package com.liubin;

import javax.swing.*;
import java.awt.*;
import java.util.LinkedList;

/**
 * @ClassName AlgoFrame
 * @Description: 算法可视化视图层
 * @Author liubin
 * @Date 2020/5/11 0011
 * @Version V1.0
 **/
public class AlgoFrame extends JFrame {

    private int canvasWidth;

    private int canvasHeight;

    /**
     *  构造器
     * */
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

    public int getCanvasWidth() {
        return canvasWidth;
    }

    public int getCanvasHeight() {
        return canvasHeight;
    }

    // 设置自己的数据
    private MonteCarloPiData data;
    public void render(MonteCarloPiData data) {
        this.data = data;
        repaint();
    }

    private class AlgoCanvas extends JPanel {
        public AlgoCanvas() {
            // 双缓存
            super(true);
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            // 转换为Graphics2D对象
            Graphics2D graphics2D = (Graphics2D) g;
            // 开启抗锯齿
            RenderingHints hints = new RenderingHints(RenderingHints.KEY_ANTIALIASING,
                    RenderingHints.VALUE_ANTIALIAS_ON);
            graphics2D.addRenderingHints(hints);
            // 具体绘制
            Circle circle = data.getCircle();
            AlgoVisHelper.setStrokeWidth(graphics2D, 3);
            AlgoVisHelper.setColor(graphics2D, AlgoVisHelper.Blue);
            AlgoVisHelper.strokeCircle(graphics2D, circle.getX(), circle.getY(), circle.getR());
            // 打点
            for (int i = 0; i < data.getPointsNumber(); i++) {
                Point point = data.getPoint(i);
                if (circle.contains(point)) {
                    AlgoVisHelper.setColor(graphics2D, AlgoVisHelper.Red);
                } else {
                    AlgoVisHelper.setColor(graphics2D, AlgoVisHelper.Green);
                }
                AlgoVisHelper.fillCircle(graphics2D, point.x, point.y, 3);
            }
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(canvasWidth, canvasHeight);
        }
    }
}
