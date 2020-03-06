/**
 * @author bys
 * @date 2019-11-17 15:13
 */
public class FirstNotRepeatingChar_34 {
    public int FirstNotRepeatingChar(String str) {
        if (str.length() == 0) {
            return -1;
        }
        //这个58是精髓
        //A-Z的ASCII码为65-90，a-z的ASCII码为97-122
        //将中间8个字符也放进数组中，这样可以免去判断大小写字符。
        int[] nums = new int[58];
        for (int i = 0; i < str.length(); i++) {
            nums[((int) str.charAt(i)) - 65] += 1;
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[((int) str.charAt(i)) - 65] == 1) {
                return i;
            }
        }
        return -1;
    }
}
