package top.zopx.arithmetic.bit;

/**
 * 实现一个位图操作
 *
 * @author 谢先生
 * @email xiezhyan@126.com
 * @date 2022/09/17 22:21
 */
public class Code_02_Bitmap {

    private final int[] bitmap;

    public Code_02_Bitmap(int max) {
        bitmap = new int[(max + 32) >> 5];
    }

    public void add(int num) {
        // 1. 找到指定下标
        // 2. 求余数得到指定下标位置的所在位上
        bitmap[num >> 5] |= (1 << (num & 31));
    }

    public void delete(int num) {
        // 指定位上为1， 取反得到0， 按位与操作必须上下为1才是1，所以可以将该位置设置为0
        bitmap[num >> 5] &= ~(1 << (num & 31));
    }

    public boolean contain(int num) {
        return (bitmap[num >> 5] & (1 << (num & 31))) != 0;
    }

    public static void main(String[] args) {
        final Code_02_Bitmap code02Bitmap = new Code_02_Bitmap(64);
        int num = 63;
        System.out.println(code02Bitmap.contain(num));
        code02Bitmap.add(num);
        System.out.println(code02Bitmap.contain(num));
        code02Bitmap.delete(num);
        System.out.println(code02Bitmap.contain(num));
    }
}
