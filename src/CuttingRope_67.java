/**
 * @PackageName:PACKAGE_NAME
 * @ClassName:CuttingRope_67
 * @Description
 * @Author: yushengbi
 * @Date:2020/3/30 10:45
 */
public class CuttingRope_67 {
    /**
     * 背包型动规，需要处理特殊值
     *
     * @param n
     * @return
     */
    public int cuttingRope(int n) {
        int[] dp = new int[n + 1];
        if (n <= 3) {
            return n - 1;
        }
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;
        for (int i = 4; i <= n; i++) {
            for (int j = 1; j <= i / 2; j++) {
                dp[i] = Math.max(dp[i - j] * j, dp[i]);
            }
        }
        return dp[n];
    }

    /**
     * 把一段绳子分成两段，第二部分还有剪和不剪两种状态
     *
     * @param n
     * @return
     */
    public int cuttingRope1(int n) {
        int[] dp = new int[n + 1];
        if (n <= 3) {
            return n - 1;
        }
        dp[1] = 1;
        dp[2] = 1;
        for (int i = 3; i <= n; i++) {
            for (int j = 2; j <= i - 1; j++) {
                dp[i] = Math.max(dp[i], Math.max(dp[i - j] * j, (i - j) * j));
            }
        }
        return dp[n];
    }
}
