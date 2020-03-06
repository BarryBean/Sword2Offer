/**
 * @PackageName:PACKAGE_NAME
 * @ClassName:JumpFloor_08
 * @Description
 * @Author: yushengbi
 * @Date:2020/2/15 13:07
 */
public class JumpFloor_08 {
    public static int JumpFloor(int target) {
        if (target == 1) {
            return 1;
        }
        int one = 1, two = 1;
        for (int i = 1; i < target; i++) {
            two+=one;
            one=two-one;
        }
        return two;
    }

    public static void main(String[] args) {
        System.out.println(JumpFloor(4));
    }
}
