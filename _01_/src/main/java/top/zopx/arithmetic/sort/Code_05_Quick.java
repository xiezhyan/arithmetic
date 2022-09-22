package top.zopx.arithmetic.sort;

/**
 * 快排
 *
 * @author 谢先生
 * @email xiezhyan@126.com
 * @date 2022/09/18 22:46
 */
public class Code_05_Quick {

    // 和数组最后一个数进行比较，<=的放左边 >的放右边
    public static void lessL(int[] arr) {
        if (arr == null || arr.length == 1) {
            return;
        }

        int index = 0;
        int lessL = -1;
        while (index < arr.length) {
            // 如果<= ，就和<=区的下一个位置进行交换
            if (arr[index] <= arr[arr.length - 1]) {
                Util.swap(arr, index++, ++lessL);
            } else {
                // 否则，当前位置继续向后
                index++;
            }
        }
    }

    /**
     * < 的放左边 = 放中间 > 放右边
     *
     * @param arr
     */
    public static void lessLAndMoreR(int[] arr) {
        if (arr == null || arr.length == 1) {
            return;
        }

        int N = arr.length;
        int lessL = -1;
        int index = 0;
        int moreR = N - 1;
        while (index < moreR) {
            if (arr[index] < arr[N - 1]) {
                Util.swap(arr, ++lessL, index++);
            } else if (arr[index] > arr[N - 1]) {
                Util.swap(arr, --moreR, index);
            } else {
                index++;
            }
        }
        Util.swap(arr, moreR, N - 1);
    }

    // 范围等于区域的范围
    public static int[] partation(int[] arr, int L, int R) {
        int lessL = L - 1;
        int index = L;
        int mostR = R;
        while (index < mostR) {
            if (arr[index] < arr[R]) {
                Util.swap(arr, ++lessL, index++);
            } else if (arr[index] > arr[R]) {
                Util.swap(arr, --mostR, index);
            } else {
                index++;
            }
        }
        Util.swap(arr, mostR, R);
        return new int[]{lessL + 1, mostR};
    }

    public static void sort(int[] arr, int L, int R) {
        if (L >= R) {
            return;
        }
        final int[] partation = partation(arr, L, R);
        sort(arr, L, partation[0] - 1);
        sort(arr, partation[1] + 1, R);
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
            sort(arr, 0, arr.length - 1);
            if (!Util.isOk(arr, copyArr)) {
                Util.print(arr);
                break;
            }
        }
        System.out.println(isOk ? "OK" : "ERROR");
    }
}
