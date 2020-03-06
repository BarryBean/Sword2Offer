/**
 * @author bys
 * @date 2019-10-14 20:15
 */
public class MoreThanHalfNum_Solution_28 {
    public static int MoreThanHalfNum_Solution(int[] array) {
        /*
        int count = 1, num = array[0];

        for (int i = 1; i < array.length; i++) {
            if (array[i] != num) {
                if(count>0){
                    count--;
                }else if (count <= 0) {
                    num = array[i];
                }
            } else {
                count++;
            }
        }
        */
        int count = 0, tmp = 0;
        for (int i = 0; i < array.length; i++) {
            if (count == 0) {
                tmp = array[i];
                count++;
            } else {
                count = array[i] == tmp ? count + 1 : count - 1;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 2, 2, 2, 5, 4, 2};
        int a = MoreThanHalfNum_Solution(array);
        System.out.println(a);
    }
}
