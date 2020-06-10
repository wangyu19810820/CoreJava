package chapter07;

import java.io.PrintWriter;
import java.io.StringWriter;

public class PrintStackTraceToString {

    public static void main(String[] args) {
        a1();
    }

    public static void a1() {
        a2();
    }

    // 将异常的堆栈信息保存到字符串中
    public static void a2() {
        var out = new StringWriter();
        Throwable throwable = new Throwable();
        throwable.printStackTrace(new PrintWriter(out));
        String str = out.toString();
        System.out.println("str=" + str);

        throwable.printStackTrace();
    }
}
