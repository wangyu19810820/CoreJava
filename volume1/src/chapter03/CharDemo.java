package chapter03;

public class CharDemo {
    // \u0000到\uFFFF 可以用在单引号和双引号之外，javac可以编译运行
    public static void main(String\u005B\u005D args) {
    /*
        单行注射内的\u0000到\uFFFF也起作用
        \u000A转义成换行，编译错误
        // \u000A is a new line
        反斜杠users，是非法的Unicode转义，编译错误
        // open dir c:反斜杠users
     */
    // public static void main(String[] args) {
        String s = "hello world!";
        System.out.println(s);
        for (int i = 0; i < s.length(); i++) {
            System.out.print("=");
        }
        System.out.println();
    }
}
