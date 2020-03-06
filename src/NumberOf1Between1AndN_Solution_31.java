/**
 * @PackageName:PACKAGE_NAME
 * @ClassName:NumberOf1Between1AndN_Solution_31
 * @Description
 * @Author: yushengbi
 * @Date:2020/2/20 11:12
 */
public class NumberOf1Between1AndN_Solution_31 {
    public static int NumberOf1Between1AndN_Solution(int n) {
        int ret = process(n, 1);
        return ret;
    }

    public static int process(int n, int x) {
        if (n < 0 || x < 1 || x > 9) {
            return 0;
        }
        int high, low, cur, tmp, i = 1;
        high = n;
        int total = 0;
        while (high != 0) {
            //获得第i位的高位=i+1位
            high = (int) (n / Math.pow(10, i));
            //后续部分
            tmp = (int) (n % Math.pow(10, i));
            //第i位
            cur = (int) (tmp / Math.pow(10, i - 1));
            //第i位的低位=i-1位
            low = (int) (tmp % Math.pow(10, i - 1));

            if (cur == x) {
                total += (int) (high * Math.pow(10, i - 1)) + low + 1;
            } else if (cur < x) {
                total += high * Math.pow(10, i - 1);
            } else {
                total += (high + 1) * Math.pow(10, i - 1);
            }
            i++;
        }
        return total;

    }

    public static void main(String[] args) {
        System.out.println(NumberOf1Between1AndN_Solution(2593));
    }
}
