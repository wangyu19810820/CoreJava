package chapter12;

public class UncaughtExceptionHandlerTest {

    public static void main(String[] args) {
        Thread.setDefaultUncaughtExceptionHandler(new MyUncaughtExceptionHandler());

        var thread = new Thread(() -> {
            int i = 10 / 0;
        });

        thread.setUncaughtExceptionHandler((t, throwable) ->
                System.out.println("UncaughtExceptionHandler " + t.getName() + " " + throwable.getMessage()));

        // 额外：获取thread的ThreadGroup和当前线程的ThreadGroup，都是java.lang.ThreadGroup[name=main,maxpri=10]
//        System.out.println(thread.getThreadGroup());
//        System.out.println(Thread.currentThread().getThreadGroup());

        thread.start();
    }

}

class MyUncaughtExceptionHandler implements Thread.UncaughtExceptionHandler {

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        System.out.println(t.getName() + ":" + e.getMessage());
    }
}