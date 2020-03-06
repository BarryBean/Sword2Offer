/**
 * @PackageName:PACKAGE_NAME
 * @ClassName:Multiply_51
 * @Description
 * @Author: yushengbi
 * @Date:2020/2/24 10:14
 */
public class Multiply_51 {
    public static int[] multiply(int[] A) {
        int[] B=new int[A.length];
        B[0]=1;
        //从上往下计算下三角
        for (int i = 1; i <A.length; i++) {
            B[i]=B[i-1]*A[i-1];
        }
        //从下往上计算上三角
        int tmp=1;
        for (int i = A.length-2; i >=0 ; i--) {
            tmp*=A[i+1];
            B[i]*=tmp;
        }

        return B;
    }

    public static void main(String[] args) {
        int[] A={2,3,4,6,8,9};
        int[] multiply = multiply(A);
        System.out.println(multiply);
    }
}
