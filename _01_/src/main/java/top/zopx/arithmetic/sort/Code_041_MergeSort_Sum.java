package top.zopx.arithmetic.sort;

import com.sun.xml.internal.ws.assembler.jaxws.MustUnderstandTubeFactory;

import java.util.Objects;

/**
 * @author 谢先生
 * @email xiezhyan@126.com
 * @date 2022/09/24 10:23
 */
public class Code_041_MergeSort_Sum {

    /**
     * 每个位置数左边比自己小的数都加起来，得到一个和
     */
    public static int sum(int[] arr) {
        if (arr == null || arr.length < 1) {
            return 0;
        }

        return process(arr, 0, arr.length - 1);
    }

    private static int process(int[] arr, int L, int R) {
        if (L == R) {
            return 0;
        }
        int mid = L + ((R - L) >> 1);
        return process(arr, L, mid) + process(arr, mid + 1, R) + merge(arr, L, mid, R);
    }

    // 已当前数为视角，找到右边比自己大的数的和
    private static int merge(int[] arr, int l, int mid, int r) {
        int[] helper = new int[r - l + 1];
        int index = 0;
        int p1 = l;
        int p2 = mid + 1;
        int ans = 0;
        while (p1 <= mid && p2 <= r) {
            ans += arr[p1] < arr[p2] ? arr[p1] * (r - p2 + 1) : 0;
            // 如果相等，让右组++
            helper[index++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
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

    public static int test(int[] arr) {
        int ans = 0;
        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {
                ans += arr[j] < arr[i] ? arr[j] : 0;
            }
        }
        return ans;
    }



    public static void main(String[] args) {

        int maxValue = 100;
        int maxLen = 5;
        int timer = 100_0000;
        boolean isOk = true;
        for (int i = 0; i < timer; i++) {
            final int[] arr = Util.randomArr(maxValue, maxLen);
            final int[] copy = Util.copy(arr);
            final int test = test(arr);
            final int sum = sum(copy);
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
