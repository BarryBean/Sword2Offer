import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @PackageName:PACKAGE_NAME
 * @ClassName:MaxInWindows_65
 * @Description
 * @Author: yushengbi
 * @Date:2020/1/22 10:57
 */
public class MaxInWindows_64 {
    /**
     * 暴力解法
     *
     * @param num
     * @param size
     * @return
     */
    public static ArrayList<Integer> maxInWindows(int[] num, int size) {
        if (size > num.length || size <= 0) {
            return new ArrayList<Integer>();
        }
        ArrayList<Integer> arrayList = new ArrayList<>();
        int begin = 0;
        while (begin < num.length - size + 1) {
            int[] subnum = subNum(num, begin, size);
            arrayList.add(retMax(subnum));
            begin++;
        }
        return arrayList;
    }

    public static int[] subNum(int[] num, int begin, int size) {
        int[] subnum = new int[size];
        int count = 0;
        for (int i = begin; i < begin + size; i++) {
            subnum[count] = num[i];
            count++;
        }
        return subnum;
    }

    public static int retMax(int[] num) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < num.length; i++) {
            if (num[i] > max) {
                max = num[i];
            }
        }
        return max == Integer.MIN_VALUE ? null : max;
    }

    /**
     * 使用大顶堆代替滑动窗口，从而保证滑动窗口内的max在第一个位置
     *
     * @param num
     * @param size
     * @return
     */
    public static ArrayList<Integer> maxInWindows2(int[] num, int size) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        if (size > num.length || size <= 0) {
            return arrayList;
        }
        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        for (int i = 0; i < size; i++) {
            queue.offer(num[i]);
        }
        arrayList.add(queue.peek());
        for (int i = 0, j = i + size; j < num.length; i++, j++) {
            queue.remove(num[i]);
            queue.add(num[j]);
            arrayList.add(queue.peek());
        }
        return arrayList;
    }

    public static void main(String[] args) {
        int[] num = {2, 3, 4, 2, 6, 2, 5, 1};
        System.out.println(maxInWindows2(num, 3));
    }
}
