import java.util.ArrayList;
import java.util.List;

/**
 * @author bys
 * @date 2019-12-30 12:09
 */
public class LastRemaining_46 {

    /**
     * 递归解法，把长度为n的环的解看作是长度为n-1的解再加上报数的长度m
     * @param n 环里存在的数
     * @param m 每隔多少挑一次
     * @return
     */
    public int lastRemainingSolution(int n, int m) {
        if (n == 0) {
            return -1;
        }
        if (n == 1) {
            return 0;
        }
        //不知道n和m的大小，做取余
        return (lastRemainingSolution(n - 1, m) + m) % n;
    }

    /**
     * 非递归解法，使用list模拟，提供一个指针用于操作
     * @param n
     * @param m
     * @return
     */
    public int lastRemainingSolution2(int n, int m) {
        if(n<1 || m<1){
            return -1;
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(i);
        }
        int cur = -1;
        while (list.size()>1){
            for (int i = 0; i < m; i++) {
                cur++;
                if(cur==list.size()){
                    cur=0;
                }
            }
            list.remove(cur);
            //将cur移出后，将指针前调
            cur--;
        }
        return list.get(0);
    }
}
