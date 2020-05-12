package com.liubin;

import java.awt.*;

/**
 * @ClassName Circle
 * @Description: 圆的类对象
 * @Author liubin
 * @Date 2020/5/12 0012
 * @Version V1.0
 **/
public class Circle {

    private int x , y, r;

    public Circle(int x, int y, int r) {
        this.x = x;
        this.y = y;
        this.r = r;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getR() {
        return r;
    }

    public boolean contains(Point point) {
        return Math.pow(point.getX() - x, 2) + Math.pow(point.getY() - y, 2) <= r * r;
    }
}
