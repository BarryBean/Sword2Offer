/**
 * @author bys
 * @date 2019-11-11 20:49
 */
public class FindGreatestSumOfSubArray_30 {
    public int FindGreatestSumOfSubArray(int[] array) {
        if (array.length == 0 && array == null) {
            return 0;
        }
        //array[0]
        int max = Integer.MIN_VALUE;
        int sum = 0;

        for (int i : array) {
            sum = sum <= 0 ? i : sum + i;
            max = Math.max(sum, max);
        }
        return max;
    }
}
