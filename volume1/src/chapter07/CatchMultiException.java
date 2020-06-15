package chapter07;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Scanner;

public class CatchMultiException {

    public static void main(String[] args) {
        try {
            try {
                a(true);
            } catch (IOException | MyException1 e) {
                System.out.println(e.getMessage());
                var exception = new SQLException("database error");
                exception.initCause(e);
                throw exception;
            }
        } catch (SQLException e) {
            System.out.println(e);
            System.out.println(e.getCause());
        }

        System.out.println("--------------------------------------------");
        try(var o = new MyAutoClose();
                var in = new Scanner(new FileInputStream("src/chapter03/input.txt"))) {
        } catch (Exception e) {
            System.out.println("OK1111111111111111");
            System.out.println(e);
            System.out.println(Arrays.toString(e.getSuppressed()));
        } finally {
            System.out.println("finally");
        }

        System.out.println("--------------------------------------------");
        var o = new MyAutoClose();
        var o1 = new MyAutoClose();
        try(o; o1) {
            throw new IOException("IOException");
        } catch (Exception e) {
            System.out.println("catch");
            e.printStackTrace();
            var exceptions = e.getSuppressed();
            for (Throwable t : exceptions) {
                t.printStackTrace();
            }
        } finally {
            System.out.println("finally");
        }
    }

    public static void a(boolean flag) throws IOException, MyException1 {
        if (flag) {
            throw new IOException();
        } else {
            throw new MyException1("ok");
        }
    }
}
