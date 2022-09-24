package top.zopx.arithmetic.sort;

import java.util.Objects;

/**
 * @author 谢先生
 * @email xiezhyan@126.com
 * @date 2022/09/24 10:23
 */
public class Code_04_02_MergeSort_DoubleSmall {

    /**
     * 任意一个数右边有多少 乘2都没有自己大
     */
    public static int run(int[] arr) {
        if (arr == null || arr.length < 1) {
            return 0;
        }

        return process(arr, 0, arr.length - 1);
    }

    private static int process(int[] arr, int l, int r) {
        if (l >= r) {
            return 0;
        }
        int mid = l + ((r - l) >> 1);
        return process(arr, l, mid) + process(arr, mid + 1, r) + merge(arr, l, mid, r);
    }

    private static int merge(int[] arr, int l, int mid, int r) {

        int ans = 0;
        // 右边的范围上比较 [mid + 1, r)
        int windowR = mid + 1;
        for (int i = l; i <= mid; i++) {
            while (windowR <= r && arr[i] > (arr[windowR] << 1)) {
                windowR++;
            }
            ans += windowR - mid - 1;
        }

        int[] helper = new int[r - l + 1];
        int index = 0;
        int p1 = l;
        int p2 = mid + 1;
        while (p1 <= mid && p2 <= r) {
            helper[index++] = arr[p1] <= arr[p2] ? arr[p1++] : arr[p2++];
        }

        while (p1 <= mid) {
            helper[index++] = arr[p1++];
        }
        while (p2 <= r) {
            helper[index++] = arr[p2++];
        }

        for (int j = 0; j < helper.length; j++) {
            arr[l + j] = helper[j];
        }
        return ans;
    }

    public static int comparator(int[] arr) {
        int ans = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > (arr[j] << 1)) {
                    ans++;
                }
            }
        }
        return ans;
    }


    public static void main(String[] args) {
        int maxValue = 100;
        int maxLen = 50;
        int timer = 100_0000;
        boolean isOk = true;
        for (int i = 0; i < timer; i++) {
            final int[] arr = Util.randomArr(maxValue, maxLen);
            final int[] copy = Util.copy(arr);
            final int test = comparator(arr);
            final int sum = run(copy);
            if (!Objects.equals(test, sum)) {
                System.out.println(test + "\t" + sum);
                Util.print(arr);
                isOk = false;
                break;
            }
        }
        System.out.println(isOk ? "Nice" : "ERROR");
    }
}
