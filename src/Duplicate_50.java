/**
 * @author bys
 * @date 2020-01-03 13:42
 */
public class Duplicate_50 {
    // Parameters:
    //    numbers:     an array of integers
    //    length:      the length of array numbers
    //    duplication: (Output) the duplicated number in the array number,length of duplication array is 1,so using duplication[0] = ? in implementation;
    //                  Here duplication like pointor in C/C++, duplication[0] equal *duplication in C/C++
    //    这里要特别注意~返回任意重复的一个，赋值duplication[0]
    // Return value:       true if the input is valid, and there are some duplications in the array number
    //                     otherwise false


    public static boolean duplicate(int[] numbers, int length, int[] duplication) {
        int[] list = new int[length];
        for (int i = 0; i < length; i++) {
            list[numbers[i]]++;
            if (list[numbers[i]] > 1) {
                duplication[0] = numbers[i];
                return true;
            }
        }
        return false;
    }

    /**
     * 空间复杂度为O(1)
     *
     * @param numbers
     * @param length
     * @param duplication
     * @return
     */
    public static boolean duplicate1(int[] numbers, int length, int[] duplication) {
        if (numbers == null || length <= 0) {
            return false;
        }
        for (int i = 0; i < length; i++) {
            while (numbers[i] != i) {
                if (numbers[i] == numbers[numbers[i]]) {
                    duplication[0] = numbers[i];
                    return true;
                }
                swap(numbers, i, numbers[i]);
            }
        }
        return false;
    }

    public static void swap(int[] nums, int i, int j) {
        nums[i] = nums[i] ^ nums[j];
        nums[j] = nums[j] ^ nums[i];
        nums[i] = nums[i] ^ nums[j];
    }

    public static void main(String[] args) {
        int[] nums = {6, 3, 1, 0, 2, 5, 4};
        int length = nums.length;
        int[] dup = new int[1];
        System.out.println(duplicate(nums, length, dup));
    }
}
