package chapter03;

public class SwitchDemo {

    enum Size {SMALL, MIDDLE, LARGE}

    // 当如此编译：javac -Xlint:fallthrough chapter03/SwitchDemo.java
    // 警告没有break，注解压制此警告
    // @SuppressWarnings("fallthrough")
    public static void main(String[] args) {
        var size = Size.MIDDLE;
        switch (size) {
            case SMALL:
                System.out.println("small");
            case MIDDLE:
                System.out.println("middle");
            case LARGE:
                System.out.println("large");
        }
    }
}
