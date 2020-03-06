/**
 * @PackageName:PACKAGE_NAME
 * @ClassName:ReOrderArray_13
 * @Description
 * @Author: yushengbi
 * @Date:2020/2/16 11:22
 */
public class ReOrderArray_13 {
    public static void reOrderArray(int[] array) {
        int count=0;
        for (int i = 0; i < array.length; i++) {
            if(array[i]%2==1){
                int j=i;
                while (j>count){
                    swap(array,j,j-1);
                    j--;
                }
                count++;
            }
        }
    }

    public static void swap(int[] nums, int a, int b) {
        int tmp = nums[b];
        nums[b] = nums[a];
        nums[a] = tmp;
    }

    public static void main(String[] args) {
        int[] nums = {1, 4, 5, 6, 9, 8, 3};
        reOrderArray(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
    }
}
