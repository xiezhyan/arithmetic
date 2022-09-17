package top.zopx.arithmetic.sort;

/**
 * 0~N-1
 * 1~N-1
 * 2~N-1
 *
 * @author 谢先生
 * @email xiezhyan@126.com
 * @date 2022/09/17 23:00
 */
public class Code_01_Select {

    public static void sort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            int minIndexValue = i;
            for (int j = i; j < arr.length; j++) {
                minIndexValue = arr[minIndexValue] < arr[j] ? minIndexValue : j;
            }
            Util.swap(arr, i, minIndexValue);
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
