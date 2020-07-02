package chapter06;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.Random;

public class ProxyTest {
    public static void main(String[] args) {
        var elemens = new Object[1000];
        for (int i = 0; i < elemens.length; i++) {
            Integer value = i + 1;
            var handler = new TraceHandler(value);
            Object proxy = Proxy.newProxyInstance(ClassLoader.getSystemClassLoader(),
                    new Class[]{ Comparable.class }, handler);
            elemens[i] = proxy;
        }
        Integer key = new Random().nextInt(elemens.length + 1);
        int result = Arrays.binarySearch(elemens, key);
        if (result >= 0) {
            System.out.println(elemens[result]);
        }
    }
}

class TraceHandler implements InvocationHandler {
    private Object target;
    public TraceHandler(Object o) {
        target = o;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.print(target);
        System.out.print("." + method.getName() + "(");
        if (args != null) {
            for (int i = 0; i < args.length; i++) {
                System.out.print(args[i]);
                if (i < args.length - 1) {
                    System.out.print(",");
                }
            }
        }
        System.out.println(")");
        return method.invoke(target, args);
    }
}
