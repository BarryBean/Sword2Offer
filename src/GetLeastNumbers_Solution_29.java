import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author bys
 * @date 2019-10-14 21:02
 */
public class GetLeastNumbers_Solution_29 {
    public static ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {

        ArrayList<Integer> result = new ArrayList<>();
        if(input.length<k || k==0 || input.length==0 || input==null){
            return result;
        }

        //快排--超出运行时间
//        int pivot = quickSort(input,0,input.length-1);
//        while (pivot!=(k-1)){
//            if(pivot>(k-1)){
//                quickSort(input,0,pivot-1);
//            }else{
//                quickSort(input,pivot+1,input.length-1);
//            }
//        }
//        for (int i = 0; i < k; i++) {
//            result.add(input[i]);
//        }


        //遍历数组，使用大小为k的堆，维护到目前为止的最小的k个数
        //将大根堆大小设置为k
        //遍历输入
        //当堆满并且堆的顶部大于当前元素时
        //使用当前元素替换堆的顶部

        //PriorityQueue默认是小顶堆，需要通过传入自定义的Comparator函数实现大顶堆

        PriorityQueue<Integer> bigHeap = new PriorityQueue<Integer>(k, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);//o2 - o1;
            }
        });
        for (int num:input){
            if(bigHeap.size()<k){
                bigHeap.add(num);
            }else {
                if(num<bigHeap.peek()){
                    bigHeap.poll();
                    bigHeap.add(num);
                }
            }
        }

        while (!bigHeap.isEmpty()){
            result.add(bigHeap.poll());
        }

        //冒泡
        for (int i = input.length-1; i >= input.length-1-k; i--) {
            for (int j = 0; j < i; j++) {
                if(input[j]>input[j+1]){
                    int temp=input[j];
                    input[j]=input[j+1];
                    input[j+1]=temp;
                }
            }
        }


        return result;
    }

    public static int quickSort(int[] array, int low, int high) {
        int left = low, right = high;
        int temp = array[left];
        while (left < right) {
            while (left < right  && array[right] >= temp) {
                right--;
            }
            array[left] = array[right];
            while (left < right  && array[left] <= temp) {
                left++;
            }
            array[right] = array[left];
        }
        array[left]=temp;
        return left;
    }

    public static void main(String[] args) {
        int[] input = {4,5,1,6,2,7,3,8};
        ArrayList<Integer> arrayList = GetLeastNumbers_Solution(input,4);
        for (int i = 0; i < arrayList.size(); i++) {
            System.out.println(arrayList.get(i));
        }
    }
}
