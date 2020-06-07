package chapter05;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Scanner;

public class EnumTest {

    enum Size {
        SMALL("S"), MEDIUM("M"), LARGE("L"), EXTRA_LARGE("XL");
        private String abbreviation;

        Size(String abbreviation) {
            this.abbreviation = abbreviation;
        }

        public String getAbbreviation() {
            return abbreviation;
        }
    }

    public static void main(String[] args) {
        var in = new Scanner(System.in);
        System.out.print("Enter a size:" + Arrays.toString(Size.values()));
        String input = in.next().toUpperCase();
        Size size = Enum.valueOf(Size.class, input);
        System.out.println("size=" + size);
        System.out.println("abbreviation=" + size.getAbbreviation());
        System.out.println("ordinal=" + size.ordinal());
        if (size == Size.EXTRA_LARGE) {
            System.out.println("Good job--you paid attention to t _.");
        }
    }
}
