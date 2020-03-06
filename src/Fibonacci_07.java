
/**
 * @PackageName:PACKAGE_NAME
 * @ClassName:Fibonacci_07
 * @Description
 * @Author: yushengbi
 * @Date:2020/2/15 11:15
 */
public class Fibonacci_07 {
    public static int Fibonacci(int n) {
        if (n == 1 || n == 2) {
            return 1;
        }
        int one = 1, two = 1, sum = 0;
        for (int i = 3; i <= n; i++) {
            sum = one + two;
            one = two;
            two = sum;
        }
        return sum;
    }
}
