package top.zopx.arithmetic.sort;

/**
 * 冒泡排序
 * 0~0 比较
 * 0~1 上变有序
 * 0~2 上变有序
 * 0~3上边有序
 *
 * @author 谢先生
 * @email xiezhyan@126.com
 * @date 2022/09/18 22:46
 */
public class Code_02_Insert {
    public static void sort(int[] arr) {
        if (arr == null || arr.length == 1) {
            return;
        }
        for (int i = 1; i < arr.length; i++) {
            while (i - 1 >= 0 && arr[i] < arr[i - 1]) {
                Util.swap(arr, i, i - 1);
                i--;
            }
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
