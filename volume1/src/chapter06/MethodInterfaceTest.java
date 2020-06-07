package chapter06;

public class MethodInterfaceTest extends BaseMethodInterfaceTest
        implements MethodInterface, MethodInterface1 {

    public static void main(String[] args) {
        var test = new MethodInterfaceTest();
        MethodInterface.print1();
        test.print();   // 父类方法优先于接口方法
        test.print2();  // 如果一个接口提供了默认方法，一个提供了同名同参数的普通方法，需要类显式覆盖
        test.print3();  // 如果两个接口提供了同名同参数的默认方法，需要显式覆盖
    }

    @Override
    public void print2() {
        MethodInterface.super.print2();
    }

    @Override
    public void print3() {
        MethodInterface1.super.print3();
    }
}

class BaseMethodInterfaceTest {
    public void print() {
        System.out.println(true);
    }
}