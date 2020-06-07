package chapter06;

import java.util.Arrays;

public class StaticInnerClassTest {

    public static void main(String[] args) {
        var values = new double[10];
        for (var i = 0; i < values.length; i++) {
            values[i] = 100 * Math.random();
        }
        ArrayAlg.Pair pair = ArrayAlg.minmax(values);
        System.out.println(Arrays.toString(values));
        System.out.println("min=" + pair.getFirst());
        System.out.println("max=" + pair.getSecond());
    }
}

class ArrayAlg {
    public static class Pair {
        private double first;
        private double second;

        public Pair(double first, double second) {
            this.first = first;
            this.second = second;
        }

        public double getFirst() {
            return first;
        }

        public double getSecond() {
            return second;
        }
    }

    // 一次循环，返回两个值，一个最大值，一个最小值
    public static Pair minmax(double[] values) {
        double min = Double.POSITIVE_INFINITY;
        double max = Double.NEGATIVE_INFINITY;
        for (double v : values) {
            if (v < min) {
                min = v;
            }
            if (v > max) {
                max = v;
            }
        }
        return new Pair(min, max);
    }
}