package chapter07;

/**
 * 改变未捕获异常的处理器
 */
public class DefaultUncaughtExceptionHandler {

    public static void main(String[] args) throws Exception {
        Thread.setDefaultUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
            @Override
            public void uncaughtException(Thread t, Throwable e) {
                System.out.println("e=" + e.getMessage());
            }
        });

        throw new Exception("a exception");
    }
}
