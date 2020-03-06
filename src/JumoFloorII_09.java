/**
 * @PackageName:PACKAGE_NAME
 * @ClassName:JumoFloorII_09
 * @Description
 * @Author: yushengbi
 * @Date:2020/2/15 13:19
 */
public class JumoFloorII_09 {
    public static int JumpFloorII1(int target) {
        if (target == 1) {
            return 1;
        } else if (target == 0) {
            return 1;
        }
        int result = 0;
        for (int i = target-1; i >= 0; i--) {
            result += JumpFloorII(i);
        }
        return result;
    }

    public static int JumpFloorII(int target) {
        if (target == 1) {
            return 1;
        } else if (target == 0) {
            return 1;
        }
        return 2*JumpFloorII(target-1);
    }


    public static void main(String[] args) {
        System.out.println(JumpFloorII(4));
    }
}
