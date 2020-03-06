/**
 * @PackageName:PACKAGE_NAME
 * @ClassName:Find_01
 * @Description
 * @Author: yushengbi
 * @Date:2020/2/13 22:32
 */
public class Find_01 {
    public boolean Find(int target, int[][] array) {
        if (array == null || array.length == 0 || array[0].length == 0 || array[0] == null) {
            return false;
        }
        int row = 0;
        int column = array[0].length-1;
        while (row < array.length && column >= 0) {
            if (target == array[row][column]) {
                return true;
            } else if (target > array[row][column]) {
                row++;
            } else {
                column--;
            }
        }
        return false;
    }
}
