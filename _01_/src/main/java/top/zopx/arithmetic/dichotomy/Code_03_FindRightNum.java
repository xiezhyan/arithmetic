package top.zopx.arithmetic.dichotomy;

import top.zopx.arithmetic.sort.Util;

import java.util.Arrays;

/**
 * 在有序数组中找到 <=num 最右的位置
 *
 * @author 谢先生
 * @email xiezhyan@126.com
 * @date 2022/09/24 17:54
 */
public class Code_03_FindRightNum {

    public static int run(int[] arr, int num) {
        if (arr == null || arr.length < 1) {
            return -1;
        }

        int l = 0;
        int r = arr.length - 1;
        int ans = -1;
        while (l <= r) {
            int mid = l + ((r - l) >> 1);
            // 因为我们要找<=num最右侧的数，所以如果mid <= num, 就继续往右找
            if (arr[mid] <= num) {
                // 并且将位置提前记录下来
                ans = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return ans;
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
            if (test(arr, num) != run(arr, num)) {
                isOk = false;
                Util.print(arr);
                System.out.println("num = " + num);
                break;
            }
        }
        System.out.println(isOk ? "OK": "ERROR");

//        int[] arr = {65, -82, -62, -10, -3, 11, 30, 78};
//        Arrays.sort(arr);
//        Util.print(arr);
//        System.out.println(test(arr, 64));
//        System.out.println(run(arr, 64));
    }

    private static int test(int[] arr, int num) {
        if (arr == null || arr.length <= 0) {
            return -1;
        }
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] <= num) {
                return i;
            }
        }
        return -1;
    }

    private static int[] generRandomArr(int maxValue, int maxLen) {
        final int[] arr = new int[(int) (Math.random() * (maxLen + 1))];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) ((maxValue + 1) * Math.random()) - (int) (Math.random() * maxValue);
        }
        return arr;
    }

}
