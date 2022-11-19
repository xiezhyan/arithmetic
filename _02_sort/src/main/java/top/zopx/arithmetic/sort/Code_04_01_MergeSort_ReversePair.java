package top.zopx.arithmetic.sort;

import java.util.Objects;

/**
 * @author 谢先生
 * @email xiezhyan@126.com
 * @date 2022/09/24 10:23
 */
public class Code_04_01_MergeSort_ReversePair {

    public static int pair(int[] arr) {
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
        int[] helper = new int[r - l + 1];
        int index = 0;
        int p1 = l;
        int p2 = mid + 1;
        int ans = 0;
        while (p1 <= mid && p2 <= r) {
            ans += arr[p1] > arr[p2] ? mid - p1 + 1 : 0;
            helper[index++] = arr[p1] > arr[p2] ? arr[p2++] : arr[p1++];
        }

        while (p1 <= mid) {
            helper[index++] = arr[p1++];
        }
        while (p2 <= r) {
            helper[index++] = arr[p2++];
        }

        for (int i = 0; i < helper.length; i++) {
            arr[l + i] = helper[i];
        }
        return ans;
    }

    public static int comparator(int[] arr) {
        int ans = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
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
            final int sum = pair(copy);
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
