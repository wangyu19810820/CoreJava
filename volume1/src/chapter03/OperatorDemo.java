package chapter03;

public strictfp class OperatorDemo {

    // strictfp表示采用严格浮点计算
    public static strictfp void main(String[] args) {
        // 得到0.8999999999999999而非0.9
        System.out.println(2.0 - 1.1);

        // 浮点数被0除，得到无穷大或者NaN
        System.out.println(Double.isInfinite(1.0 / 0));
        System.out.println(Double.isNaN(1.0 / 0));
        System.out.println(1.0 / 0);
        // 负数的平方根是NaN
        System.out.println(Double.isNaN(Math.sqrt(-2.0)));

        // 用Math.floorMod计算负数的余数，得到正值。对于负除数，仍然会得到负值。
        System.out.println(-1 % 2);
        System.out.println(Math.floorMod(-1, 2));
        System.out.println(Math.floorMod(1, -2));

        // 四舍五入，结果是long型
        int i = (int)Math.round(3.7);
        System.out.println(i);

        // +=如果左右两边类型不同，会强制转换
        i += 3.5;
        System.out.println(i);

        System.out.println("-------------------------------");
        int j = 0b110;
        System.out.println(j);
        System.out.println(j & 0b10);
        // &用于boolean值时,不发生短路行为
        System.out.println(false && j++ > 5);
        System.out.println(j);
        System.out.println(false & j++ > 5);
        System.out.println(j);

        // 左移，右移,右操作数是整形要取32的模，是长整形取64的模，>>>用0填充高位
        System.out.println("-------------------------------");
        System.out.println(0b110 >> 2);
        System.out.println(0b110 << 2);
        System.out.println(0b110 << 34);
        System.out.println(0b110L << 34);
        System.out.println(0b110L << 66);
        System.out.println(-0b110 >> 2);
        System.out.println(-0b110 >>> 2);
    }
}
