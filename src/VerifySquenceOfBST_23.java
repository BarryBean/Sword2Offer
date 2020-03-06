/**
 * @PackageName:PACKAGE_NAME
 * @ClassName:VerifySquenceOfBST_23
 * @Description
 * @Author: yushengbi
 * @Date:2020/2/18 9:44
 */
public class VerifySquenceOfBST_23 {
    public static boolean VerifySquenceOfBST(int[] sequence) {
        if (sequence.length == 0) {
            return false;
        }
        return process(sequence,0,sequence.length-1);
    }

    public static boolean process(int[] set, int left, int right) {
        if (left >= right) {
            return true;
        }
        int split = right;
        while (split > left && set[split - 1] > set[right]) {
            split--;
        }
        for (int i = 0; i < split; i++) {
            if (set[i] > set[right]) {
                return false;
            }
        }
        return process(set, left, split - 1) && process(set, split, right - 1);
    }

    public static void main(String[] args) {
        int[] nums={1,3,6,5,11,10,13,12,7};
        System.out.println(VerifySquenceOfBST(nums));
    }
}
