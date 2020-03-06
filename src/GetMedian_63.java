import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @PackageName:PACKAGE_NAME
 * @ClassName:GetMedian_64
 * @Description
 * @Author: yushengbi
 * @Date:2020/1/22 10:42
 */
public class GetMedian_63 {
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>(new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2 - o1;
        }
    });
    int count = 0;

    public void Insert(Integer num) {
        //保证小顶堆中的数都大于大顶堆中的数
        if (count % 2 == 0) {
            //偶数，先加入大顶堆，再将大顶堆中最大的数插入小顶堆中
            maxHeap.add(num);
            int max = maxHeap.poll();
            minHeap.add(max);
        } else {
            //奇数，先加入小顶堆，再将小顶堆中最小的数插入大顶堆中
            minHeap.add(num);
            int min = minHeap.poll();
            maxHeap.add(min);
        }
        count++;
    }

    public Double GetMedian() {
        if (count % 2 == 0) {
            return Double.valueOf(maxHeap.peek() + minHeap.peek()) / 2;
        } else {
            return Double.valueOf(minHeap.peek());
        }
    }
}
