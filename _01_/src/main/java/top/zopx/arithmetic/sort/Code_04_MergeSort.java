package top.zopx.arithmetic.sort;

/**
 * 归并排序
 * 左右两边比较，谁小谁拷贝到辅助数组中
 *
 * @author 谢先生
 * @email xiezhyan@126.com
 * @date 2022/09/18 22:46
 */
public class Code_04_MergeSort {
    public static void sort(int[] arr) {
        if (arr == null || arr.length == 1) {
            return;
        }

        process(arr, 0, arr.length - 1);
    }

    private static void process(int[] arr, int L, int R) {
        // 有效的范围内
        if (L >= R) {
            return;
        }

        int mid = L + ((R - L) >> 1);
        process(arr, L, mid);
        process(arr, mid + 1, R);
        mergeSort(arr, L, mid, R);
    }

    private static void mergeSort(int[] arr, int L, int M, int R) {
        final int[] helper = new int[R - L + 1];
        int i = 0;
        int p1 = L;
        int p2 = M + 1;
        while (p1 <= M && p2 <= R) {
            helper[i++] = arr[p1] <= arr[p2] ? arr[p1++] : arr[p2++];
        }

        while (p1 <= M) {
            helper[i++] = arr[p1++];
        }
        while (p2 <= R) {
            helper[i++] = arr[p2++];
        }

        for (int j = 0; j < helper.length; j++) {
            arr[L + j] = helper[j];
        }
    }

    public static void main(String[] args) {
        int maxValue = 200;
        int time = 100_0000;
        int maxLen = 100;

        boolean isOk = true;
        int[] arr, copyArr;
        for (int i = 0; i < time; i++) {
            arr = Util.randomArr(maxValue, maxLen);
            copyArr = Util.copy(arr);
            Util.sort(copyArr);
            sort(arr);
            if (!Util.isOk(arr, copyArr)) {
                Util.print(arr);
                break;
            }
        }
        System.out.println(isOk ? "OK" : "ERROR");
    }
}
