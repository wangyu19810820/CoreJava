package chapter12;

import javax.imageio.metadata.IIOMetadataFormatImpl;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ThreadLocalRandom;

public class ThreadLocalTest {
    public static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    // ThreadLocal
    public static final ThreadLocal<SimpleDateFormat> dateFormat1
            = ThreadLocal.withInitial(() -> new SimpleDateFormat("yyyy-MM-dd"));

    public static void main(String[] args) {
        for (int i = 0; i < 20; i++) {
            new Thread(() -> {
                for (int j = 0; j < 100; j++) {
                    String dateStr = dateFormat.format(new Date());
                    System.out.println(dateStr);

                    String dateStr1 = dateFormat1.get().format(new Date());
                    System.out.println("dateStr1 " + dateStr1);

                    // 多线程获取随机数
                    int random = ThreadLocalRandom.current().nextInt(100);
                    System.out.println(random);
                }
            }).start();
        }
    }
}
