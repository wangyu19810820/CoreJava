package chapter03;

import java.io.Console;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Scanner;

public class InputOutputDemo {

    public static void main(String[] args) throws IOException {
//        var scanner = new Scanner(System.in);
//        System.out.print("what is your name?");
//        var name = scanner.nextLine();
//        System.out.print("How old are you?");
//        var age = scanner.nextInt();
//        var str = String.format("Hello %s, next year you will be %d", name, age + 1);
//        System.out.println(str);

        System.out.println(System.getProperty("user.dir"));
        Scanner in = new Scanner(Path.of("D:\\Documents\\GitHub\\CoreJava\\volume1\\out\\production\\Volume1Demo\\chapter03\\input.txt"), StandardCharsets.UTF_8);
        System.out.println("file:" + in.nextLine() + in.nextLine());

        var scanner1 = new Scanner("16\ninputoutdemo.txt");
        System.out.println(scanner1.nextInt() + scanner1.nextLine() + scanner1.nextLine());

        // idea throw NullPointerException
//        Console console = System.console();
//        var name = console.readLine("username:");
//        var password = console.readPassword("password:");
//        System.out.print("username:" + name + " and password:");
//        for(char c : password) {
//            System.out.print(c);
//        }
//        System.out.println();


    }
}
