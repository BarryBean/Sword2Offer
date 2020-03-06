/**
 * @author bys
 * @date 2019-11-12 14:50
 */
public class GetUglyNumber_Solution_33 {
    public static int GetUglyNumber_Solution(int N) {
        //遍历整个正整数，会超时
       /*if (index <= 6) {
            return index;
        }
        ArrayList<Integer> num=new ArrayList<>();

        int tmp=0;
        boolean flag=false;
        int i=7;
        while (num.size()<index-6) {
N
            while (!flag){
                tmp = GetSlice(i,2);
                tmp = GetSlice(tmp,3);
                tmp = GetSlice(tmp,5);

                if(tmp==1){
                    num.add(i);
                    i++;
                    break;
                }else {
                    i++;
                }
            }
        }
        return num.get(index-7);*/


        if (N <= 6) {
            return N;
        }
        int i2 = 0, i3 = 0, i5 = 0;
        int[] dp = new int[N];
        dp[0] = 1;
        for (int i = 1; i < N; i++) {
            int next2 = dp[i2] * 2, next3 = dp[i3] * 3, next5 = dp[i5] * 5;
            dp[i] = Math.min(next2, Math.min(next3, next5));
            if (dp[i] == next2) {
                i2++;
            }
            if (dp[i] == next3) {
                i3++;
            }
            if (dp[i] == next5) {
                i5++;
            }
        }
        return dp[N - 1];
    }

    /*public static int GetSlice(int N,int M){
        int tmp = N%M;
        while(tmp==0){
            N=N/M;
            tmp=N%M;
            if (N==1) break;
        }
        return N;
    }*/

    public static void main(String[] args) {
        int a = GetUglyNumber_Solution(11);
        System.out.println(a);
    }
}
