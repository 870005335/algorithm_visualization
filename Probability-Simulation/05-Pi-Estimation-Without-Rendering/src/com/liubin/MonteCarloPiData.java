package com.liubin;

import java.awt.*;
import java.util.LinkedList;

/**
 * @ClassName MonteCarloPiData
 * @Description: 使用蒙特卡洛方法求Pi值
 * @Author liubin
 * @Date 2020/5/12 0012
 * @Version V1.0
 **/
public class MonteCarloPiData {

    private Circle circle;

    private LinkedList<Point> points;

    private int insideCircle = 0;

    public MonteCarloPiData(Circle circle) {
        this.circle = circle;
        this.points = new LinkedList<>();
    }

    public Circle getCircle() {
        return circle;
    }

    public int getPointsNumber() {
        return points.size();
    }

    public Point getPoint(int i) {
        if (i < 0 || i >= points.size())
            throw new IllegalArgumentException("out of bound in getPoint!");

        return points.get(i);
    }

    public void addPoint(Point point) {
        points.add(point);
        if (circle.contains(point)) {
            this.insideCircle++;
        }
    }

    public double estimatePi() {
        if (points.size() == 0) {
            return 0.0;
        }
        int circleArea = insideCircle;
        int squareArea = points.size();
        return (double) circleArea * 4 / squareArea;
    }
}