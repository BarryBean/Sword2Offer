/**
 * @author bys
 * @date 2019-12-29 16:09
 */
public class ReverseSentence_44 {
    /**
     * 标准答案，不适用额外空间
     * 先旋转每个单词，再旋转整个句子
     *
     * @param str
     * @return
     */
    public static String ReverseSentence(String str) {
        if(str==null||str.equals("")){
            return str;
        }

        int n = str.length();
        char[] chars = str.toCharArray();
        int i = 0, j = 0;
        while (j <= n) {
            if (j == n || chars[j] == ' ') {
                //每次遇到空格及到末尾，就代表一个单词，旋转一次
                reverse(chars, i, j - 1);
                //更新i
                i = j + 1;
            }
            //j往前走
            j++;
        }
        //旋转整个句子
        reverse(chars, 0, n - 1);
        return String.valueOf(chars);
    }

    public static void reverse(char[] chars, int i, int j) {
        while (i < j) {
            swap(chars, i++, j--);
        }
    }

    public static void swap(char[] chars, int i, int j) {
        char tmp = chars[i];
        chars[i] = chars[j];
        chars[j] = tmp;
    }

    /**
     * 使用java的语言特性
     * 单词字母顺序正确，拼接字符串
     *
     * @param str
     * @return
     */
    public static String ReverseSentence2(String str) {
        if (str == null || str.trim().equals("")) {
            return str;
        }
        String[] strings = str.split(" ");
        StringBuffer sb = new StringBuffer();
        for (int i = strings.length - 1; i >= 0; i--) {
            sb.append(strings[i]);
            if (i > 0) {
                sb.append(' ');
            }
        }
        return sb.toString();
    }


    public static void main(String[] args) {
        String str = "student. a am I";
        System.out.println(ReverseSentence(str));
        System.out.println(ReverseSentence2(str));
    }
}
