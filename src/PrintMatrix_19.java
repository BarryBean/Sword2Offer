import java.util.ArrayList;

/**
 * @author bys
 * @date 2019-10-11 20:25
 */
public class PrintMatrix_19 {
    public ArrayList<Integer> printMatrix(int[][] matrix) {
        ArrayList<Integer> result = new ArrayList<>();
        int a1 = 0, a2 = matrix.length - 1, b1 = 0, b2 = matrix[0].length - 1;
        while (a1 <= a2 && b1 <= b2) {
            for (int i = b1; i <= b2; i++) {
                result.add(matrix[a1][i]);
            }
            for (int i = a1 + 1; i <= a2; i++) {
                result.add(matrix[i][b2]);
            }
            if (a1 != a2) {
                for (int i = b2-1; i >= b1; i--) {
                    result.add(matrix[a2][i]);
                }
            }
            if (b1 != b2) {
                for (int i = a2-1; i > a1; i--) {
                    result.add(matrix[i][b1]);
                }
            }
            a1++;
            a2--;
            b1++;
            b2--;
        }
        return result;
    }
}
