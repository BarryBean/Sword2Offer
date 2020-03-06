/**
 * @PackageName:PACKAGE_NAME
 * @ClassName:Sum_Solution_47
 * @Description
 * @Author: yushengbi
 * @Date:2020/2/26 11:36
 */
public class Sum_Solution_47 {
    public static int Sum_Solution(int n) {
        int sum = n;
        boolean flag = (sum > 0) && ((sum += Sum_Solution(--n)) > 0);
        return sum;
    }

    public static int Sum_Solution1(int n) {
        return ((int) Math.pow(n, 2) + n) >> 1;
    }

    public static int Sum_Solution2(int n) {
        int res = 0;
        int a = n, b = n + 1;
        while (a != 0) {
            if ((a & 1) == 1) {
                res += b;
            }
            a >>= 1;
            b <<= 1;
        }
        return res >>= 1;

    }

    private int multi(int a, int b) {
        int res = 0;
        //循环体内部, if ((a & 1) == 1), res += b;
        boolean flag1 = ((a & 1) == 1) && (res += b) > 0;
        a >>= 1;
        b <<= 1;
        // while (a != 0) {}循环条件
        boolean flag2 = (a != 0) && (res += multi(a, b)) > 0;
        return res;
    }

    public static void main(String[] args) {
        System.out.println(Sum_Solution(3));
        System.out.println(Sum_Solution1(3));
    }
}
