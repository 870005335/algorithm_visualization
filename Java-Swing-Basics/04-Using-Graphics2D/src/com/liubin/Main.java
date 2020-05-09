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
        EventQueue.invokeLater(() -> {
            AlgoFrame algoFrame = new AlgoFrame("Welcome", 500, 500);
        });
    }
}
