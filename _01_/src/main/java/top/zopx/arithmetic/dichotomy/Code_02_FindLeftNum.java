package top.zopx.arithmetic.dichotomy;

import top.zopx.arithmetic.sort.Util;

import java.util.Arrays;

/**
 * 在有序数组中找到 >=num 最左的位置
 *
 * @author 谢先生
 * @email xiezhyan@126.com
 * @date 2022/09/24 17:54
 */
public class Code_02_FindLeftNum {

    public static int run(int[] arr, int num) {
        if (arr == null || arr.length < 1) {
            return -1;
        }

        int l = 0;
        int r = arr.length - 1;
        int ans = -1;
        while (l <= r) {
            int mid = l + ((r - l) >> 1);
            // 我们要找>=num最左侧的值，所以如果mid 比 num 还大，那就继续往左边找
            if (arr[mid] >= num) {
                // 并且将等于的位置提前记录下来
                ans = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return  ans;
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

//        int[] arr = {-82	,-62	,-10	,-3,	11	,30	,78	};
//        System.out.println(test(arr, 64));
//        System.out.println(run(arr, 64));
    }

    private static int test(int[] arr, int num) {
        if (arr == null || arr.length <= 0) {
            return -1;
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= num) {
                return i;
            }
        }
        return -1;
    }

    private static int[] generRandomArr(int maxValue, int maxLen) {
        final int[] arr = new int[(int)(Math.random() * (maxLen + 1))];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int)((maxValue + 1) * Math.random()) - (int)(Math.random() * maxValue);
        }
        return arr;
    }

}
