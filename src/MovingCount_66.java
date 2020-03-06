/**
 * @PackageName:PACKAGE_NAME
 * @ClassName:MovingCount_66
 * @Description
 * @Author: yushengbi
 * @Date:2020/2/24 15:41
 */
public class MovingCount_66 {
    public static int count = 0;

    public static int movingCount(int threshold, int rows, int cols) {
        if (rows == 0 || cols == 0) {
            return -1;
        }
        int[][] matrix = new int[rows][cols];
        //for (int i = 0; i < rows; i++) {
            //for (int j = 0; j < cols; j++) {
                process(threshold, rows, cols, 0, 0, matrix);
            //}
        //}
        return count;
    }

    public static void process(int threshold, int rows, int cols, int row, int col, int[][] matrix) {
        int bitSum = countBit(row, col);
        if (row < 0 || col < 0 || row >= rows || col >= cols || bitSum > threshold || matrix[row][col] != 0) {
            return;
        }
        count++;
        matrix[row][col] = 1;
        process(threshold, rows, cols, row - 1, col, matrix);
        process(threshold, rows, cols, row + 1, col, matrix);
        process(threshold, rows, cols, row, col - 1, matrix);
        process(threshold, rows, cols, row, col + 1, matrix);
    }

    public static int countBit(int row, int col) {
        int sum = 0;
        while (row != 0) {
            sum += row % 10;
            row = row / 10;
        }
        while (col != 0) {
            sum += col % 10;
            col = col / 10;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(movingCount(3, 3, 3));
    }
}
