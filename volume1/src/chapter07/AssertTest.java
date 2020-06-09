package chapter07;

public class AssertTest {

    public static void main(String[] args) {
        double n = abs(-22.2);
        assert n >= 0 : "n must >= 0 but n = " + n;
        System.out.println(n);
    }

    public static double abs(double n) {
        return n;
    }
}
