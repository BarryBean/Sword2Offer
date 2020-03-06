/**
 * @author bys
 * @date 2019-12-30 12:42
 */
public class StrToInt_49 {

    public static int StrToInt(String str) {
        int length = str.length();
        int isNegative = 1, overValue = 0;
        int digit = 0, value = 0;

        if (length == 0) {
            return 0;
        }
        char[] chars = str.toCharArray();

        int index = 0;
        if (chars[0] == '-') {
            isNegative = -1;
            index = 1;
        } else if (chars[0] == '+') {
            index = 1;
        } else {
            index = 0;
        }

        while (index < length) {
            digit = chars[index] - '0';
            //overValue用于判断此轮循环是否过界，>0过界，<0安全
            overValue = isNegative * value - Integer.MAX_VALUE / 10 +
                    (((isNegative + 1) / 2 + digit > 8) ? 1 : 0);
            if (digit < 0 || digit > 9) {
                return 0;
            } else if (overValue > 0) {
                return 0;
            }
            value = value * 10 + isNegative * digit;
            index++;
        }

        return value;
    }


    public static void main(String[] args) {
        String str = "-132";
        System.out.println(StrToInt(str));
    }
}
