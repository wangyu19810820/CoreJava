package chapter03;

import java.util.Scanner;

public class BreakDemo {

    public static void main(String[] args) {
        var in = new Scanner(System.in);
        var input = in.nextInt();
        label1: {
            if (input > 10) {
                // 跳出label1块
                break label1;
            }
            System.out.println("input:" + input);
        }

        label2:
        while(input < 20) {
            System.out.print("please input:");
            input = in.nextInt();

            System.out.println("out loop");
            for (var i = 0; i < input; i++) {
                System.out.print(i + " ");
                if (i > 5) {
                    // 跳出内层循环，开始新的外层循环
                    continue label2;
                }
            }
            System.out.println();
        }
    }
}
