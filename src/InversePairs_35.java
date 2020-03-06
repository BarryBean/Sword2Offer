/**
 * @PackageName:PACKAGE_NAME
 * @ClassName:InversePairs_35
 * @Description
 * @Author: yushengbi
 * @Date:2020/2/25 9:34
 */
public class InversePairs_35 {
    public static int InversePairs(int[] array) {
        if (array == null || array.length < 2) {
            return 0;
        }
        return mergeSort(array, 0, array.length - 1);
    }

    private static int mergeSort(int[] array, int left, int right) {
        if (left == right) {
            return 0;
        }
        int mid = left + (right - left) / 2;
        return (mergeSort(array, left, mid) +
                mergeSort(array, mid + 1, right) +
                merge(array, left, mid, right))%1000000007;
    }

    private static int merge(int[] array, int left, int mid, int right) {
        int[] help = new int[right - left + 1];
        int i = 0, p1 = left, p2 = mid + 1, result = 0;
        while (p1 <= mid && p2 <= right) {
            //并入的时候，利用有序性
            result += array[p1] > array[p2] ? (mid - p1 + 1) : 0;
            //测试用例特别大，题目也要求取余
            result = result>1000000007?result%1000000007:result;
            help[i++] = array[p1] > array[p2] ? array[p2++] : array[p1++];
        }
        while (p1 <= mid) {
            help[i++] = array[p1++];
        }
        while (p2 <= right) {
            help[i++] = array[p2++];
        }
        for (int j = 0; j < help.length; j++) {
            array[left ++] = help[j];
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 0};
        System.out.println(InversePairs(nums));
    }
}
