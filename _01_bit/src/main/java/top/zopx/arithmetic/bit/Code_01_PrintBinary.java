package top.zopx.arithmetic.bit;

import java.util.Objects;

/**
 * 打印一个整数的二进制表达形式
 *
 * @author 谢先生
 * @email xiezhyan@126.com
 * @date 2022/09/17 22:10
 */
public class Code_01_PrintBinary {

    public static String printBit(int num) {
        String result = "";
        for (int i = 31; i >= 0; i--) {
            result += (num >> i & 1);
        }
        return result;
    }

    public static String test(int num) {
        return String.format("%032d", Integer.parseInt(Integer.toBinaryString(num)));
    }

    public static int random(int maxValue) {
        // 1~maxValue 之前的随机数
        return (int) (Math.random() * maxValue + 1);
    }

    public static void main(String[] args) {
        int maxValue = 100;
        int time = 500_0000;
        System.out.println("测试开始！！！");
        boolean isOk = true;
        for (int i = 0; i < time; i++) {
            final int num = random(maxValue);
            if (!Objects.equals(test(num), printBit(num))) {
                System.out.println(num + "出错了");
                break;
            }
        }
        System.out.println(isOk ? "测试结束！！！" : "Error");
    }

}
