package top.zopx.arithmetic.sort;

/**
 * 冒泡排序
 * 0~1之间谁大谁往后
 * 1~2之间谁大谁往后
 * 2~3之间谁大谁往后
 *
 * @author 谢先生
 * @email xiezhyan@126.com
 * @date 2022/09/18 22:46
 */
public class Code_02_Bubble {
    public static void sort(int[] arr) {
        if (arr == null || arr.length == 1) {
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            // 0 1      2 1   3 2
            for (int j = 1; j < arr.length; j++) {
                if (arr[j] < arr[j - 1]) {
                    Util.swap(arr, j, j - 1);
                }
            }
        }
    }

    public static void sort_2(int[] arr) {
        if (arr == null || arr.length == 1) {
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            // 0 1      2 1   3 2
            for (int j = 1; j < arr.length - i; j++) {
                if (arr[j] < arr[j - 1]) {
                    Util.swap(arr, j, j - 1);
                }
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
            sort_2(arr);
            if (!Util.isOk(arr, copyArr)) {
                Util.print(arr);
                break;
            }
        }
        System.out.println(isOk ? "OK" : "ERROR");
    }
}
