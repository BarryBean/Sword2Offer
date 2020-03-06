/**
 * @author bys
 * @date 2019-11-17 16:12
 */
public class GetNumberOfK_37 {
    /**
     * 最简单的遍历数组找到begin和end
     * @param array
     * @param k
     * @return
     */
    public static int GetNumberOfK(int[] array, int k) {
        int begin = 0, count = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] >= k) {
                break;
            } else {
                begin++;
            }
        }

        for (int i = begin; i < array.length; i++) {
            if (array[i] == k) {
                count++;
            } else {
                break;
            }
        }

        return count;
    }

    /**
     * 牛客上的独特思路，将k+-0.5，找到这两数的插入位置
     * @param array
     * @param k
     * @return
     */
    public static int GetNumberOfK2(int[] array, int k) {
        return search(array, (float) (k + 0.5)) - search(array, (float) (k - 0.5));
    }

    private static int search(int[] array, float k) {
        int start = 0, end = array.length - 1;
        while (start <= end) {
            int mid = (end-start) / 2 + start;
            if (array[mid] < k) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return start;
    }

    /**
     * 二分查找找到begin和end
     * @param array
     * @param k
     * @return
     */
    public static int GetNumberOfK1(int[] array, int k) {
        int lower = getLower(array, k);
        int higher = getHigher(array, k);
        return higher - lower + 1;
    }

    private static int getHigher(int[] array, int k) {
        int start = 0, end = array.length - 1;
        int mid =  (end-start) / 2 + start;

        while (start <= end) {
            if (array[mid] <= k) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
            mid = (end-start) / 2 + start;
        }
        return end;
    }

    private static int getLower(int[] array, int k) {
        int start = 0, end = array.length - 1;
        int mid = (end-start) / 2 + start;

        while (start <= end) {
            if (array[mid] < k) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
            mid =  (end-start) / 2 + start;
        }
        return start;
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 3, 3, 3};
        int a = GetNumberOfK(array, 3);
        int number = GetNumberOfK1(array, 3);
        int number1 = GetNumberOfK2(array, 3);
        System.out.println(a);
        System.out.println(number);
        System.out.println(number1);
    }
}
