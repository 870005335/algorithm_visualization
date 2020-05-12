package com.liubin;

import java.awt.*;
import java.util.Arrays;


/**
 * @ClassName AlgoVisualizer
 * @Description: 算法可视化控制层
 * @Author liubin
 * @Date 2020/5/11 0011
 * @Version V1.0
 **/
public class AlgoVisualizer {

    // 创建自己的数据
    private int[] money; // 数据

    private AlgoFrame frame; // 视图

    public AlgoVisualizer(String title, int sceneWidth, int sceneHeight) {
        // 初始化数据
        money = new int[100];
        Arrays.fill(money, 100);

        // 初始化视图
        EventQueue.invokeLater(() -> {
            frame = new AlgoFrame(title, sceneWidth, sceneHeight);
            new Thread(this::run).start();
        });
    }


    private void run() {
        while (true) {
            // 进行排序 更清晰地展示分布情况
            Arrays.sort(money);
            // 编写自己的动画逻辑
            frame.render(money);
            int delay = 40;
            AlgoVisHelper.pause(delay);
            // 更新数据
            // 为了加快模拟过程 每K轮更新一次
            for (int k = 0; k < 50; k++) {
                for (int i = 0; i < money.length; i++) {
                    // 允许出现负值的情况
//                    if (money[i] > 0) {
                        int j = (int) (Math.random() * money.length);
                        money[i] -= 1;
                        money[j] += 1;
//                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        int sceneWidth = 1000;
        int sceneHeight = 500;
        String title = "A-Money-Experiment-Basics";
        AlgoVisualizer visualizer = new AlgoVisualizer(title, sceneWidth, sceneHeight);
    }
}
