import java.util.ArrayList;

/**
 * @PackageName:PACKAGE_NAME
 * @ClassName:FindNumbersWithSum_42
 * @Description
 * @Author: yushengbi
 * @Date:2020/2/22 15:05
 */
public class FindNumbersWithSum_42 {
    public static ArrayList<Integer> FindNumbersWithSum(int[] array, int sum) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        if (array == null || array.length == 0) {
            return arrayList;
        }
        int start = 0, end = array.length - 1, multiply = Integer.MAX_VALUE;
        while (start < end) {
            int tmp = array[start] + array[end];
            if (tmp > sum) {
                end--;
                continue;
            } else if (tmp < sum) {
                start++;
                continue;
            }
            multiply = array[start] * array[end] > multiply ? multiply : array[start] * array[end];
            if (multiply == array[start] * array[end]) {
                arrayList.clear();
                arrayList.add(array[start]);
                arrayList.add(array[end]);
            }

            start++;
        }
        return arrayList;
    }

    public static void main(String[] args) {
        int[] array = {2, 3, 4, 6, 8, 9, 10};
        System.out.println(FindNumbersWithSum(array, 14));
    }
}
