package com.liubin;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.MouseAdapter;


/**
 * @ClassName AlgoVisualizer
 * @Description: 算法可视化控制层
 * @Author liubin
 * @Date 2020/5/11 0011
 * @Version V1.0
 **/
public class AlgoVisualizer {

    // TODO 创建自己的数据
    private Object data; // 数据

    private AlgoFrame frame; // 视图

    public AlgoVisualizer(String title, int sceneWidth, int sceneHeight) {
        // 初始化数据
        // TODO 初始化数据

        // 初始化视图
        EventQueue.invokeLater(() -> {
            frame = new AlgoFrame(title, sceneWidth, sceneHeight);
            // TODO 根据情况决定是否加入键盘和鼠标事件
            frame.addKeyListener(new AlgoKeyListener());
            frame.addMouseListener(new AlgoMouseListener());
            new Thread(this::run).start();
        });
    }

    private void run() {
        //TODO 编写自己的动画逻辑
    }

    private class AlgoKeyListener extends KeyAdapter {

    }

    private class AlgoMouseListener extends MouseAdapter {

    }

    public static void main(String[] args) {

    }
}
