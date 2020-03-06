/**
 * @PackageName:PACKAGE_NAME
 * @ClassName:MinNumberInRotateArray_06
 * @Description
 * @Author: yushengbi
 * @Date:2020/2/15 10:26
 */
public class MinNumberInRotateArray_06 {
    /**
     * 稍微优化后的遍历
     *
     * @param array
     * @return
     */
    public static int minNumberInRotateArray1(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }
        for (int i = 0; i < array.length; i++) {
            if (array[i + 1] < array[i]) {
                return array[i + 1];
            }
        }
        return array[0];
    }

    public static int minNumberInRotateArray(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }
        int start = 0, end = array.length - 1;
        int mid = 0;
        while (array[start] >= array[end]) {
            if (end - start == 1) {
                mid = end;
                break;
            }
            mid = (start + end) / 2;
            if (array[start] == array[end]) {
                minOrder(array, start, end);
            }
            if (array[mid] >= array[start]) {
                start = mid;
            } else {
                end = mid;
            }
        }
        return array[mid];
    }

    private static int minOrder(int[] array, int start, int end) {
        int result = array[start];
        for (int i = 0; i < end; i++) {
            if (array[i] < result) {
                result = array[i];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] num = {3, 4, 4, 5, 1, 2};
        System.out.println(minNumberInRotateArray(num));
    }
}
