/**
 * @author bys
 * @date 2019-12-29 17:12
 */
public class IsContinuous_45 {
    public static boolean isContinuous(int[] numbers) {
        if (numbers.length < 5) {
            return false;
        }
/*
        int count = 0;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == 0) {
                count++;
            }
        }

        Arrays.sort(numbers);

        for (int i = count; i < numbers.length - 1; i++) {
            //除0外不能有其他重复值
            if (numbers[i] == numbers[i + 1]) {
                return false;
            }
            //max-min<5
            if (numbers[4] - numbers[i] >= 5) {
                return false;
            }
        }
        return true;
*/

        int[] repeat = new int[14];
        repeat[0] = -5;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        //改为一次遍历，且不用java的特性
        for (int i = 0; i < numbers.length; i++) {
            repeat[numbers[i]]++;
            if (numbers[i] == 0) {
                //啥事都不做
                continue;
            }
            if (repeat[numbers[i]] > 1) {
                return false;
            }
            min = numbers[i] < min ? numbers[i] : min;
            max = numbers[i] > max ? numbers[i] : max;
        }
        return max - min < 5 ? true : false;

    }

    public static void main(String[] args) {
        int[] nums = new int[5];
        nums[0] = 0;
        nums[1] = 1;
        nums[2] = 0;
        nums[3] = 0;
        nums[4] = 6;
        System.out.println(isContinuous(nums));
    }
}
