package top.zopx.arithmetic.bit;

/**
 * @author 谢先生
 * @email xiezhyan@126.com
 * @date 2022/09/17 22:21
 */
public class Code_03_XOR {

    /**
     * 数组中一种数出现奇数次，其他都是偶数次，打印出出现奇数次的数
     *
     * @param arr
     * @return
     */
    public static int getOddNum(int[] arr) {
        if (arr == null || arr.length == 0) {
            return -1;
        }

        int ans = 0;
        for (int i = 0, size = arr.length; i < size; i++) {
            ans ^= arr[i];
        }
        return ans;
    }

    /**
     * 数组中两种数出现奇数次，其他都是偶数次，打印出出现奇数次的数
     */
    public static int[] getTwoOddNums(int[] arr) {
        if (arr == null || arr.length == 0) {
            return null;
        }

        int ans = 0;
        for (int i = 0, size = arr.length; i < size; i++) {
            ans ^= arr[i];
        }

        // 此时 ans = a ^ b   能够得到ans最右侧的1
        int rightOne = ans & (-ans);
        int onlyOne = 0;
        for (int i = 0, size = arr.length; i < size; i++) {
            if ((rightOne & arr[i]) != 0) {
                onlyOne ^= arr[i];
            }
        }
        return new int[]{onlyOne, onlyOne ^ ans};
    }

    public static void print(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "\t");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        print(getTwoOddNums(new int[]{1,1,1,2,2,4,4,4,6,5,5,6}));
    }
}
