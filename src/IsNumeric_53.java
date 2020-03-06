/**
 * @PackageName:PACKAGE_NAME
 * @ClassName:IsNumeric_53
 * @Description
 * @Author: yushengbi
 * @Date:2020/2/24 11:07
 */
public class IsNumeric_53 {

    public static boolean isNumeric(char[] str) {
        if (str.length < 1 || str == null) {
            return false;
        }
        boolean dot = false, hasE = false;
        for (int i = 0; i < str.length; i++) {
            if (str[i] == 'e' || str[i] == 'E') {
                //e后必须跟数字
                if (i == str.length - 1) {
                    return false;
                }
                //不能有两个E
                if (hasE) {
                    return false;
                }
                hasE = true;
            } else if (str[i] == '+' || str[i] == '-') {
                //+-出现开头，后面必须为数字
                //中间出现+-，一定跟在e后
                if (i > 0 && (str[i - 1] != 'e' && str[i - 1] != 'E')) {
                    return false;
                }
            } else if (str[i] == '.') {
                //小数点只能出现一次
                //e后不能有小数点
                if (dot || hasE) {
                    return false;
                }
                dot = true;
            } else if (str[i] < '0' || str[i] > '9') {
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        char[] str = {'5', '3', '.', '1','4','e','+','6'};
        System.out.println(isNumeric(str));
    }
}


