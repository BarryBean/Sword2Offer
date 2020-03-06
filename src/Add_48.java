/**
 * @PackageName:PACKAGE_NAME
 * @ClassName:Add_48
 * @Description
 * @Author: yushengbi
 * @Date:2020/2/26 13:00
 */
public class Add_48 {
    public static int Add(int num1, int num2) {
        int res = 0, carry = 0;
        do {
            res = num1 ^ num2;
            carry = (num1 & num2)<<1;
            num1 = res;
            num2 = carry;
        }while (carry != 0);
        return res;
    }

    public static void main(String[] args) {
        System.out.println(Add(3,5));
    }
}
