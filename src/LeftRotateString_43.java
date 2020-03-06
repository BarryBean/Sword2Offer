/**
 * @author bys
 * @date 2019-12-29 15:25
 */
public class LeftRotateString_43 {
    /**
     * 使用java的String特性，裁剪拼接得结果
     *
     * @param str
     * @param n
     * @return
     */
    public static String leftRotateString1(String str, int n) {
        int length = str.length();
        if (str == null || str.length() == 0) {
            return "";
        }
        if (n > length) {
            n = n % length;
        }
        if (n == length) {
            return str;
        }
        //左闭右开区间
        String tmp = str.substring(0, n);
        String res = str.substring(n, length).concat(tmp);
        return res;
    }


    public static void main(String[] args) {
        String str = "abcXYZdef";
        System.out.println(leftRotateString1(str, 3));
    }
}
