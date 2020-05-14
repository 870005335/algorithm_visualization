package com.liubin;

/**
 * @ClassName WinningPrize
 * @Description: 中奖测试
 * @Author liubin
 * @Date 2020/5/14 0014
 * @Version V1.0
 **/
public class WinningPrize {

    private int N;

    private double chance;

    private int playTimes;

    public WinningPrize(int n, double chance, int playTimes) {
        N = n;
        this.chance = chance;
        this.playTimes = playTimes;
    }

    public void run() {
        int wins = 0;
        for (int i = 0; i < N; i++) {
            if (play()) {
                wins ++ ;
            }
        }
        System.out.println("winning rate: " + (double)wins/N);
    }

    private boolean play() {
        for (int i = 0; i < playTimes; i++) {
            if (Math.random() < chance) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        double chance = 0.2;
        int playTimes = 5;
        int N = 1000000;
        WinningPrize prize = new WinningPrize(N, chance, playTimes);
        prize.run();
    }
}
