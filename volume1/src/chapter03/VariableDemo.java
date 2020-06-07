package chapter03;

public class VariableDemo {

    enum Size{SMALL, MEDIUM, LARGE};

    public static void main(String[] args) {
        // java10开始,局部变量可以用类型推断
        // 变量可以用字符开头,或者$和_，接字符或数字
        var $num1 = 3;
        var 字符串 = "aaa";
        for (var _i = 0; _i < $num1; _i++) {
            System.out.println(字符串);
        }
        // 是否是java标识符开头，是否是标识符部分
        System.out.println(Character.isJavaIdentifierStart('0'));
        System.out.println(Character.isJavaIdentifierPart('0'));

        // 枚举
        Size s = null;
        s = Size.LARGE;
        System.out.println(s);
    }
}
