package top.zopx.arithmetic.sort;

import java.sql.Statement;
import java.util.Arrays;

/**
 * @author 谢先生
 * @email xiezhyan@126.com
 * @date 2022/09/17 23:00
 */
public class Util {

    public static int[] copy(int[] arr) {
        int[] copy = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            copy[i] = arr[i];
        }
        return copy;
    }

    public static void print(int[] arr) {
        for (int num : arr) {
            System.out.print(num + ",");
        }
        System.out.println();
    }

    public static void sort(int[] arr) {
        Arrays.sort(arr);
    }

    public static boolean isOk(int[] test, int[] arr) {
        for (int i = 0; i < test.length; i++) {
            if (test[i] != arr[i]) {
                return false;
            }
        }
        return true;
    }

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static int[] randomArr(int maxValue, int maxLen) {
        final int[] arr = new int[(int)(Math.random() * maxLen)];
        for (int i = 0; i < arr.length; i++) {
            arr[i] =
                    (int)(Math.random() * maxValue + 1) - (int)(Math.random() * maxValue);
        }
        return arr;
    }
}
