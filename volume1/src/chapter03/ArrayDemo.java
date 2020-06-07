package chapter03;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayDemo {

    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        System.out.print("How many numbers do you need to draw? ");
        int k = scanner.nextInt();
        System.out.print("What is the highest number you can draw? ");
        var n = scanner.nextInt();

        var numbers = new int[n];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = i + 1;
        }
        System.out.println(Arrays.toString(numbers));

        var result = new int[k];
        for (var i = 0; i < result.length; i++) {
            int r = (int)(Math.random() * n);
            result[i] = numbers[r];
            numbers[r] = numbers[n - 1];
            n--;
        }

        Arrays.sort(result);
        for (var r : result) {
            System.out.println(r);
        }
    }
}
