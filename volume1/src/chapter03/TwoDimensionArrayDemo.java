package chapter03;

import java.util.Arrays;

public class TwoDimensionArrayDemo {

    public static void main(String[] args) {
        final double STARTRATE = 10;
        final int NRATES = 6;
        final int NYEARS = 10;

        double[] interestRate = new double[NRATES];
        for (var j = 0; j < interestRate.length; j++) {
            interestRate[j] = (STARTRATE + j) / 100;
        }

        double[][] balance = new double[NYEARS][NRATES];
        for(var j = 0; j < balance[0].length; j++) {
            balance[0][j] = 10_000;
        }

        for (var i = 1; i < balance.length; i++) {
            for (var j = 0; j < balance[i].length; j++) {
                double oldBalance = balance[i - 1][j];
                double interest = oldBalance * interestRate[j];
                balance[i][j] = oldBalance + interest;
            }
        }

        for (var i : interestRate) {
            System.out.printf("%9.0f%%", i * 100);
        }
        System.out.println();

        for(var row : balance) {
            for (var b : row) {
                System.out.printf("%10.2f", b);
            }
            System.out.println();
        }
    }
}
