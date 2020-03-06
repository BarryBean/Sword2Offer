/**
 * @PackageName:PACKAGE_NAME
 * @ClassName:Power_12
 * @Description
 * @Author: yushengbi
 * @Date:2020/2/25 9:12
 */
public class Power_12 {
    public static double Power(double base, int exponent) {
        if (base == 0) {
            return 0;
        }
        double res = 1;
        if (exponent == 0) {
            return res;
        }
        int n = exponent > 0 ? exponent : -exponent;
        for (int i = 1; i <= n; i++) {
            res*=base;
        }
        return exponent >= 0 ? res : (1 / res);
    }

    public static void main(String[] args) {
        System.out.println(Power(2.5,2));
    }
}
