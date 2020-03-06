/**
 * @PackageName:PACKAGE_NAME
 * @ClassName:NumberOf1_11
 * @Description
 * @Author: yushengbi
 * @Date:2020/2/26 22:24
 */
public class NumberOf1_11 {
    /**
     * 无符号右移。正负数都补0.
     * @param n
     * @return
     */
    public static int NumberOf1(int n) {
        int count = 0;
        while (n != 0) {
            count += (n & 1);
            n = n >>> 1;
        }
        return count;
    }

    /**
     * 进行32次左移判断
     * @param n
     * @return
     */
    public static int NumberOf12(int n) {
        int count = 0, flag = 1;
        while (flag != 0) {
            count = (n & flag) != 0 ? count + 1 : 0;
            flag <<= 1;
        }
        return count;
    }

    /**
     * n & n-1 ，会把n最右一个1变成0
     * @param n
     * @return
     */
    public static int NumberOf13(int n) {
        int count = 0;
        while (n != 0) {
            count++;
            n = (n - 1) & n;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(NumberOf1(5));
        System.out.println(NumberOf12(-4));
        System.out.println(NumberOf13(-4));
    }
}
