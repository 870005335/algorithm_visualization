package com.liubin;

import javax.swing.*;
import java.awt.*;

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
    private int[] money;
    public void render(int[] money) {
        this.money = money;
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
            int w = canvasWidth / money.length;
            for (int i = 0; i < money.length; i++) {
                if (money[i] > 0) {
                    AlgoVisHelper.setColor(graphics2D, AlgoVisHelper.Blue);
                    AlgoVisHelper.fillRectangle(graphics2D, i * w + 1, canvasHeight / 2 - money[i]
                            , w - 1, money[i]);
                } else {
                    AlgoVisHelper.setColor(graphics2D, AlgoVisHelper.Red);
                    AlgoVisHelper.fillRectangle(graphics2D, i * w + 1, canvasHeight / 2
                            , w - 1, -money[i]);
                }
            }
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(canvasWidth, canvasHeight);
        }
    }
}
