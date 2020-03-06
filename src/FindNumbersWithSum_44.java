import java.util.ArrayList;

/**
 * @PackageName:PACKAGE_NAME
 * @ClassName:FindNumbersWithSum_44
 * @Description
 * @Author: yushengbi
 * @Date:2020/1/23 14:02
 */
public class FindNumbersWithSum_44 {
    /**
     * 两个指针，一个指向min，一个指向max
     *
     * @param array 递增排序
     * @param sum   两数之和
     * @return
     */
    public static ArrayList<Integer> FindNumbersWithSum(int[] array, int sum) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        if (array == null || array.length == 0) {
            return arrayList;
        }
        int small = 0, big = array.length - 1;
        //乘积
        int mix = Integer.MAX_VALUE;

        while (small < big) {
            if (array[small] + array[big] > sum) {
                big--;
                continue;
            } else if (array[small] + array[big] < sum) {
                small++;
                continue;
            }

            mix = array[small] * array[big] < mix ? array[small] * array[big] : mix;
            if (mix == array[small] * array[big]) {
                arrayList.clear();
                arrayList.add(array[small]);
                arrayList.add(array[big]);
            }
            //一对数字和为sum时，small big随意选一个向前走
            small++;
        }
        return arrayList;
    }

    public static void main(String[] args) {
        int[] array = {1, 3, 4, 5, 6, 9, 10};
        System.out.println(FindNumbersWithSum(array, 9));
    }

}
