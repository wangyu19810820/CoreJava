package chapter03;

import java.util.Arrays;

public class UnRegularArrayDemo {

    public static void main(String[] args) {
        final int NMAX = 10;
        int[][] odds = new int[NMAX + 1][];
        for (int i = 0; i < odds.length; i++) {
            odds[i] = new int[i + 1];
        }

        for(int n = 0; n < odds.length; n++) {
            for (int k = 0; k < odds[n].length; k++) {
                int lotteryOdds = 1;
                for (int i = 1; i <=k; i++) {
                    lotteryOdds = lotteryOdds * (n - i + 1) / i;
                }
                odds[n][k] = lotteryOdds;
            }
        }

        System.out.println(Arrays.deepToString(odds));
        for (var row : odds) {
            for (var odd: row) {
                System.out.printf("%4d", odd);
            }
            System.out.println();
        }
    }
}
