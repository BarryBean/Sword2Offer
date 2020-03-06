import java.util.Arrays;
import java.util.Comparator;

/**
 * @author bys
 * @date 2019-11-11 21:36
 */
public class PrintMinNumber_32 {
    public static String PrintMinNumber(int[] numbers) {
        if (numbers == null || numbers.length == 0) {
            return "";
        }
        int n = numbers.length;
        String[] nums = new String[n];
        for (int i = 0; i < n; i++) {
            nums[i] = numbers[i] + "";
        }
        Arrays.sort(nums, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o1 + o2).compareTo(o2 + o1);
            }
        });
        String ret = "";

        for (String tmp : nums) {
            ret += tmp;
        }
        return ret;
    }

    public static void main(String[] args) {
        int[] numbers = {3, 32, 321};
        String str = PrintMinNumber(numbers);
        System.out.println(str);
    }
}
