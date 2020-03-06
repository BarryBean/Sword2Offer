import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * @author bys
 * @date 2019-12-30 18:46
 */
public class Permutation_27 {

    private static ArrayList<String> arrayList = new ArrayList<>();

    public static ArrayList<String> Permutation(String str) {
        if (str == null || str.length() == 0 || str.length() >= 10) {
            return arrayList;
        }
        char[] chars = str.toCharArray();
        process(chars, 0);
        Collections.sort(arrayList);
        //arrayList.sort(new MyComparator());
        return arrayList;
    }

    /**
     * 第i位上的字母向后交换
     * @param chars
     * @param i
     */
    public static void process(char[] chars, int i) {
        if (i == chars.length) {
            if (!arrayList.contains(String.valueOf(chars))) {
                arrayList.add(String.valueOf(chars));
            }
        }
        for (int j = i; j < chars.length; j++) {
            swap(chars, i, j);
            process(chars, i + 1);
            //还原
            swap(chars, i, j);
        }
    }

    public static void swap(char[] chars, int i, int j) {
        char tmp = chars[i];
        chars[i] = chars[j];
        chars[j] = tmp;
    }

    public static class MyComparator implements Comparator<String> {
        @Override
        public int compare(String o1, String o2) {
            char[] chars1 = o1.toCharArray();
            char[] chars2 = o2.toCharArray();
            for (int i = 0; i < chars1.length; i++) {
                if (chars1[i] == chars2[i]) {
                    continue;
                } else {
                    return chars1[i] - chars2[i];
                }
            }
            return o1.length() - o2.length();
        }
    }

    public static void main(String[] args) {
        System.out.println(Permutation("abc"));
    }
}
