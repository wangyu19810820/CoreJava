package chapter09;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesTest {

    public static void main(String[] args) throws IOException {
        var settings = new Properties();
        settings.setProperty("width", "200");
        settings.setProperty("fileName", "abc.txt");

        // 保存
        settings.store(new FileOutputStream("src/chapter09/settings.properties"), "Program Settings");

        // 加载
        settings.load(new FileInputStream("src/chapter09/settings.properties"));
        System.out.println(settings.getProperty("width"));
        System.out.println(settings.getProperty("file", "aaa.txt"));

        // 设置默认属性
        var newSetting = new Properties(settings);
        newSetting.setProperty("width", "300");
        System.out.println(newSetting.getProperty("width"));
        System.out.println(newSetting.getProperty("fileName", "aaa.txt"));
        System.out.println(newSetting.getProperty("height"));

        // 获取系统属性
        System.out.println(System.getProperty("user.dir"));
        System.out.println(System.getProperty("java.version"));
    }
}
