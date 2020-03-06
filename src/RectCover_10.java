/**
 * @PackageName:PACKAGE_NAME
 * @ClassName:RectCover_10
 * @Description
 * @Author: yushengbi
 * @Date:2020/2/15 13:38
 */
public class RectCover_10 {
    public static int RectCover(int target) {
        if (target == 0) {
            return 0;
        } else if (target == 1) {
            return 1;
        } else if (target == 2) {
            return 2;
        }
        return RectCover(target - 1) + RectCover(target - 2);
    }
}
