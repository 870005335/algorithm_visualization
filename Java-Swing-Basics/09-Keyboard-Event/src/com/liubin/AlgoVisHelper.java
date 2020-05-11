package com.liubin;

import java.awt.*;
import java.awt.geom.Ellipse2D;

/**
 * @ClassName AlgoVisHelper
 * @Description:
 * @Author liubin
 * @Date 2020/5/9 0009
 * @Version V1.0
 **/
public class AlgoVisHelper {
    private AlgoVisHelper() {

    }

    /**
     * @MethodName: setStrokeWidth
     * @Description: 设置绘制图形边宽
     * @Param: [g2d, width]
     * @Return: void
     * @Author: liubin
     * @Date: 2020/5/9 0009 15:51
     **/
    public static void setStrokeWidth(Graphics2D g2d, int width) {
        g2d.setStroke(new BasicStroke(width, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
    }

    /**
     * @MethodName: drawCircle
     * @Description: 绘制一个半径为r的空心圆
     * @Param: [g2d, x, y, r]
     * @Return: void
     * @Author: liubin
     * @Date: 2020/5/9 0009 16:05
     **/
    public static void drawCircle(Graphics2D g2d, int x, int y, int r) {
        Ellipse2D ellipse2D = new Ellipse2D.Double(x - r, y - r, 2 * r, 2 * r);
        g2d.draw(ellipse2D);
    }

    /**
     * @MethodName: fillCircle
     * @Description: 绘制一个半径为r的实心圆
     * @Param: [g2d, x, y, r]
     * @Return: void
     * @Author: liubin
     * @Date: 2020/5/9 0009 16:06
     **/
    public static void fillCircle(Graphics2D g2d, int x, int y, int r) {
        Ellipse2D ellipse2D = new Ellipse2D.Double(x - r, y - r, 2 * r, 2 * r);
        g2d.fill(ellipse2D);
    }

    /**
     * @MethodName: setColor
     * @Description: 设置绘画颜色
     * @Param: [g2d, color]
     * @Return: void
     * @Author: liubin
     * @Date: 2020/5/9 0009 16:18
     **/
    public static void setColor(Graphics2D g2d, Color color) {
        g2d.setColor(color);
    }

    public static void pause(int time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
