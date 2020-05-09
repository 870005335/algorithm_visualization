package com.liubin;

import javax.swing.*;

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
        this.setSize(canvasWidth, canvasHeight);
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
}
