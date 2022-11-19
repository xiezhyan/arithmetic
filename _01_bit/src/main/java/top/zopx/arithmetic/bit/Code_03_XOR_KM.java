package top.zopx.arithmetic.bit;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * 数组中一种数出现K次，其他都是M次，M > 1, K < M 找到出现K次的数
 *
 * @author 谢先生
 * @email xiezhyan@126.com
 * @date 2022/09/17 22:21
 */
public class Code_03_XOR_KM {

    public static int get(int[] arr, int k, int m) {
        if (arr == null || arr.length == 0) {
            return -1;
        }

        int[] helper = new int[32];
        for (int i = 0, size = arr.length; i < size; i++) {
            for (int j = 31; j >= 0; j--) {
                helper[j] += ((arr[i] >> j) & 1);
            }
        }

        int ans = 0;
        for (int i = 0, size = helper.length; i < size; i++) {
            if (helper[i] % m != 0) {
                ans |= (1 << i);
            }
        }
        return ans;
    }

    /**
     * 非暴力，不合作
     * @param arr
     * @param k
     * @param m
     * @return
     */
    public static int test(int[] arr, int k, int m) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0, size = arr.length; i < size; i++) {
            if (map.containsKey(arr[i])) {
                map.put(arr[i], map.get(arr[i]) + 1);
            } else {
                map.put(arr[i], 1);
            }
        }
        for (Integer key : map.keySet()) {
            if (map.get(key) == k) {
                return key;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int kinds = 5;
        int range = 30;
        int testTime = 100000;
        int max = 9;
        System.out.println("测试开始");
        for (int i = 0; i < testTime; i++) {
            int a = (int) (Math.random() * max) + 1; // a 1 ~ 9
            int b = (int) (Math.random() * max) + 1; // b 1 ~ 9
            int k = Math.min(a, b);
            int m = Math.max(a, b);
            // k < m
            if (k == m) {
                m++;
            }
            int[] arr = randomArray(kinds, range, k, m);
            int ans1 = test(arr, k, m);
            int ans3 = get(arr, k, m);
            if (ans1 != ans3) {
                System.out.println(ans1);
                System.out.println(ans3);
                System.out.println("出错了！");
            }
        }
        System.out.println("测试结束");
    }

    // 为了测试
    public static int[] randomArray(int maxKinds, int range, int k, int m) {
        int ktimeNum = randomNumber(range);
        // 真命天子出现的次数
        int times = k;
        // 2
        int numKinds = (int) (Math.random() * maxKinds) + 2;
        // k * 1 + (numKinds - 1) * m
        int[] arr = new int[times + (numKinds - 1) * m];
        int index = 0;
        for (; index < times; index++) {
            arr[index] = ktimeNum;
        }
        numKinds--;
        HashSet<Integer> set = new HashSet<>();
        set.add(ktimeNum);
        while (numKinds != 0) {
            int curNum = 0;
            do {
                curNum = randomNumber(range);
            } while (set.contains(curNum));
            set.add(curNum);
            numKinds--;
            for (int i = 0; i < m; i++) {
                arr[index++] = curNum;
            }
        }
        // arr 填好了
        for (int i = 0; i < arr.length; i++) {
            // i 位置的数，我想随机和j位置的数做交换
            int j = (int) (Math.random() * arr.length);// 0 ~ N-1
            int tmp = arr[i];
            arr[i] = arr[j];
            arr[j] = tmp;
        }
        return arr;
    }

    // 为了测试
    // [-range, +range]
    public static int randomNumber(int range) {
        return (int) (Math.random() * (range + 1)) - (int) (Math.random() * (range + 1));
    }
}
