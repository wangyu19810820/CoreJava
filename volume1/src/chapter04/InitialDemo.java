package chapter04;

public class InitialDemo {

    {
        a = "bb";
        b = "yy";
        // 可以设置a，但是不能读取a, Error:(8, 28) java: 非法前向引用
        // System.out.println(a);
        System.out.println("ok");
    }

    static {
        System.out.println("ok1");
    }

    private String a = "aa";
    private static String b = "xx";

    public InitialDemo() {
        //this("cc");
        System.out.println("InitialDemo1");
    }

    public InitialDemo(String a) {
        System.out.println("InitialDemo2");
        this.a = a;
    }

    public static void main(String[] args) {
        System.out.println(new InitialDemo().a);
        System.out.println(InitialDemo.b);
    }
}
