package top.zopx.arithmetic.sort;

/**
 * @author 谢先生
 * @email xiezhyan@126.com
 * @date 2022/09/24 10:23
 */
public class Code_04_04_MergeSort_CountOfRangeSum {

    public int countRangeSum(int[] nums, int lower, int upper) {
        if (nums == null || nums.length < 1) {
            return 0;
        }
        // 1. 求每个位置的前缀和数组
        // 2. 转换： 已左组为目标，左组有多少在每个右组 x-upper，x-lower上
        long[] preSum = new long[nums.length];
        preSum[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            preSum[i] = preSum[i - 1] + nums[i];
        }

        return process(preSum, 0, preSum.length - 1, lower, upper);
    }

    private int process(long[] preSum, int l, int r, int lower, int upper) {
        if (l == r) {
            return preSum[l] >= lower && preSum[l] <= upper ? 1 : 0;
        }

        int mid = l + ((r - l) >> 1);
        return process(preSum, l, mid, lower, upper) + process(preSum, mid + 1, r, lower, upper) + merge(preSum, l, mid, r, lower, upper);
    }

    private int merge(long[] preSum, int l, int mid, int r, int lower, int upper) {
        int ans = 0;
        int windowL = l;
        int windowR = l;
        for (int i = mid + 1; i <= r; i++) {
            long min = preSum[i] - upper;
            long max = preSum[i] - lower;

            while (windowL <= mid && preSum[windowL] < min) {
                windowL++;
            }
            while (windowR <= mid && preSum[windowR] <= max) {
                windowR++;
            }

            ans += windowR - windowL;
        }

        long[] helper = new long[r - l + 1];
        int index = 0;
        int p1 = l;
        int p2 = mid + 1;
        while (p1 <= mid && p2 <= r) {
            helper[index++] = preSum[p1] <= preSum[p2] ? preSum[p1++] : preSum[p2++];
        }
        while (p1 <= mid) {
            helper[index++] = preSum[p1++];
        }
        while (p2 <= r) {
            helper[index++] = preSum[p2++];
        }
        for (int i = 0; i < helper.length; i++) {
            preSum[i + l] = helper[i];
        }
        return ans;
    }

    public static void main(String[] args) {
        final int[] arr = {-2147483647, 0, -2147483647, 2147483647};
        System.out.println(new Code_04_04_MergeSort_CountOfRangeSum().countRangeSum(arr, -564, 3864));
        System.out.println(-2147483647L + (-2147483647L));
    }
}
