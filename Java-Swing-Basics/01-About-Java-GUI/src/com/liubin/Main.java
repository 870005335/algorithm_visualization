package com.liubin;

import javax.swing.*;
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
        EventQueue.invokeLater(() -> {
            JFrame frame = new JFrame("Welcome");
            // 设置窗口大小
            frame.setSize(500, 500);
            // 禁止改变窗口大小
//            frame.setResizable(false);
            // 设置默认关闭事件
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            // 可视化窗口
            frame.setVisible(true);
        });
    }
}
