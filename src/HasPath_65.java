/**
 * @PackageName:PACKAGE_NAME
 * @ClassName:HasPath_65
 * @Description
 * @Author: yushengbi
 * @Date:2020/2/24 14:20
 */
public class HasPath_65 {
    public static boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
        if (matrix == null) {
            return false;
        }

        int[][] dpMatrix = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (process(matrix, rows, cols, i, j, str, 0, dpMatrix)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean process(char[] matrix, int rows, int cols, int row, int col, char[] str, int index, int[][] dp) {

        int cur = cols * row + col;
        if (row >= rows || col >= cols || row < 0 || col < 0 || dp[row][col] == 1 || matrix[cur] != str[index]) {
            return false;
        }
        if (index == str.length - 1) {
            return true;
        }
        //没走过
        //开始将走过的位置置1
        dp[row][col] = 1;
        if (process(matrix, rows, cols, row + 1, col, str, index + 1, dp) ||
                process(matrix, rows, cols, row - 1, col, str, index + 1, dp) ||
                process(matrix, rows, cols, row, col + 1, str, index + 1, dp) ||
                process(matrix, rows, cols, row, col - 1, str, index + 1, dp)) {
            return true;
        }
        //走不通，还原
        dp[row][col] = 0;
        return false;
    }

    public static void main(String[] args) {
        char[] matrix = {'a', 'b', 'c', 'e', 's', 'f', 'c', 's', 'a', 'd', 'e', 'e'};
        char[] str = {'a', 'b', 'c', 'p'};
        System.out.println(hasPath(matrix, 3, 4, str));
    }
}
