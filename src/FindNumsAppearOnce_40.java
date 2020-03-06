import java.util.HashSet;
import java.util.Set;

/**
 * @author bys
 * @date 2019-11-22 21:31
 */
//num1,num2分别为长度为1的数组。传出参数
//将num1[0],num2[0]设置为返回结果
public class FindNumsAppearOnce_40 {
    public void FindNumsAppearOnce1(int[] array, int num1[], int num2[]) {
        Set<Integer> set = new HashSet<>();
        for (int a : array) {
            if (set.contains(a)) {
                set.remove(a);
            } else {
                set.add(a);
            }
        }

        num1[0] = (int) set.toArray()[0];
        num2[0] = (int) set.toArray()[1];
    }

    public static void FindNumsAppearOnce(int[] array, int num1[], int num2[]) {
        if (array.length == 2) {
            num1[0] = array[0];
            num2[0] = array[1];
            return;
        }
        int bit = 0;
        //从头开始，两两异或
        for (int i = 0; i < array.length; i++) {
            //保存所有元素异或的结果
            //最后结果是两个不同数字的异或即两个1+其余的0
            bit ^= array[i];
        }
        //找到第一个1所在的位置
        int index = 0;
        while (((bit & 1) == 0) && index <= 32) {
            bit>>=1;
            index++;
        }
        for (int i = 0; i < array.length; i++) {
            //根据第一个1的位置，将数组划分
            if (((array[i] >> index) & 1) == 1) {
                num1[0] ^= array[i];

            } else {
                num2[0] ^= array[i];
            }
        }
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 5, 7, 2, 1, 5, 8, 8, 3};
        int[] num1 = new int[1];
        int[] num2 = new int[1];
        FindNumsAppearOnce(array, num1, num2);
        System.out.println(num1[0]);
        System.out.println(num2[0]);
    }
}
