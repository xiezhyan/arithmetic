package top.zopx.arithmetic.dichotomy;

import top.zopx.arithmetic.sort.Util;

import javax.xml.bind.ValidationException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 在有序数组中找到指定num
 *
 * @author 谢先生
 * @email xiezhyan@126.com
 * @date 2022/09/24 17:54
 */
public class Code_01_FindNum {

    public static boolean run(int[] arr, int num) {
        if (arr == null || arr.length < 1) {
            return false;
        }

        int l = 0;
        int r = arr.length - 1;
        while (l <= r) {
            int mid = l + ((r - l) >> 1);
            if (arr[mid] == num) {
                return true;
            } else if (arr[mid] < num) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return  false;
    }


    public static void main(String[] args) {
        int maxValue = 100;
        int maxLen = 10;
        int time = 100_0000;
        int[] arr;
        int num;
        boolean isOk = true;
        for (int i = 0; i < time; i++) {
            arr = generRandomArr(maxValue, maxLen);
            Arrays.sort(arr);
            num = (int)(Math.random() * (maxValue + 1));
            Util.print(arr);
            if (test(arr, num) != run(arr, num)) {
                isOk = false;
                Util.print(arr);
                break;
            }
        }
        System.out.println(isOk ? "OK": "ERROR");

//        final int[] arr = {2, 5, 6, 8, 10};
//        System.out.println(test(arr, 1));
//        System.out.println(run(arr, 1));
    }

    private static boolean test(int[] arr, int num) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], i);
        }
        return map.containsKey(num);
    }

    private static int[] generRandomArr(int maxValue, int maxLen) {
        final int[] arr = new int[(int)(Math.random() * (maxLen + 1))];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int)((maxValue + 1) * Math.random()) - (int)(Math.random() * maxValue);
        }
        return arr;
    }

}
