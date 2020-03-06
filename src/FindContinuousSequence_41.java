import java.util.ArrayList;

/**
 * @PackageName:PACKAGE_NAME
 * @ClassName:FindContinuousSequence_41
 * @Description
 * @Author: yushengbi
 * @Date:2020/2/22 13:55
 */
public class FindContinuousSequence_41 {
    /**
     * 暴力解
     *
     * @param sum
     * @return
     */
    public static ArrayList<ArrayList<Integer>> FindContinuousSequence1(int sum) {
        ArrayList<ArrayList<Integer>> arrayLists = new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();
        int count = 0;
        for (int i = 1; i <= sum / 2; i++) {
            for (int j = i; j <= sum / 2 + 1; j++) {
                count += j;
                list.add(j);
                if (count == sum) {
                    arrayLists.add(new ArrayList<>(list));
                } else if (count > sum) {
                    break;
                }
            }
            count = 0;
            list.clear();
        }
        return arrayLists;
    }

    /**
     * 滑动窗口
     * @param sum
     * @return
     */
    public static ArrayList<ArrayList<Integer>> FindContinuousSequence2(int sum) {
        ArrayList<ArrayList<Integer>> arrayLists = new ArrayList<>();

        int start = 1, end = 2;
        while (end > start) {
            //求和公式
            int cursum = (end + start) * (end - start + 1) / 2;
            //相等
            if (cursum == sum) {
                ArrayList<Integer> list = new ArrayList<>();
                for (int i = start; i <= end; i++) {
                    list.add(i);
                }
                arrayLists.add(list);
                start++;
            } else if (cursum < sum) {
                //小了就扩大范围
                end++;
            } else {
                //大了就缩小范围
                start++;
            }
        }
        return arrayLists;
    }


    public static void main(String[] args) {
        System.out.println(FindContinuousSequence1(100));
        System.out.println(FindContinuousSequence2(100));
    }
}
