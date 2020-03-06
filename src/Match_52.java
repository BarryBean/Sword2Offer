/**
 * @PackageName:PACKAGE_NAME
 * @ClassName:Match_52
 * @Description
 * @Author: yushengbi
 * @Date:2020/2/26 9:48
 */
public class Match_52 {
    public static boolean match(char[] str, char[] pattern) {

        if (str == null || pattern == null) {
            return false;
        }
        int strIndex = 0, patternIndex = 0;
        return process(str, strIndex, pattern, patternIndex);
    }

    private static boolean process(char[] str, int strIndex, char[] pattern, int patternIndex) {
        if (strIndex == str.length && patternIndex == pattern.length) {
            return true;
        }
        //str未到末尾，pattern到末尾
        if (strIndex != str.length && patternIndex == pattern.length) {
            return false;
        }
        //str到尾，pattern未到尾
        if (strIndex == str.length && patternIndex != pattern.length) {
            //只有pattern剩下的部分类似a*b*c*的形式，才匹配成功
            if (patternIndex + 1 < pattern.length && pattern[patternIndex + 1] == '*') {
                return process(str, strIndex, pattern, patternIndex + 2);
            }
            return false;
        }
        //str和pattern都未到尾
        //pattern后跟*
        if (patternIndex + 1 < pattern.length && pattern[patternIndex + 1] == '*') {
            if (pattern[patternIndex] == str[strIndex] || (pattern[patternIndex] == '.' && strIndex != str.length)) {
                return process(str, strIndex, pattern, patternIndex + 2)//*匹配0个，跳过
                        || process(str, strIndex + 1, pattern, patternIndex + 2)//*匹配1个，跳过
                        || process(str, strIndex + 1, pattern, patternIndex);//*匹配1个，再匹配str中的下一个
            } else {
                //*匹配0个，直接跳过
                return process(str, strIndex, pattern, patternIndex + 2);
            }
        }
        //pattern后不跟*，两串都++
        if (pattern[patternIndex] == str[strIndex] || (pattern[patternIndex] == '.' && strIndex != str.length)) {
            return process(str, strIndex + 1, pattern, patternIndex + 1);
        }
        return false;
    }


    /*    int strIndex = 0, patternIndex = 0;
            while (strIndex < str.length && patternIndex < pattern.length) {
            //匹配串字符跟*
            if (patternIndex + 1 < pattern.length && pattern[patternIndex + 1] == '*') {
                //当前相同，pattern往后走
                if (pattern[patternIndex] == str[strIndex]) {
                    while (str[strIndex] == pattern[patternIndex]) {
                        strIndex++;
                    }
                    patternIndex++;
                    strIndex--;

                } else if (pattern[patternIndex] == '.') {
                    //匹配串匹配任意
                    while (str[strIndex] == str[strIndex + 1]) {
                        strIndex++;
                    }
                    patternIndex++;
                } else {
                    patternIndex++;
                    strIndex--;
                }
            } else {
                //匹配串后不跟*
                if (pattern[patternIndex] == '.' || pattern[patternIndex] == str[strIndex]) {
                } else {
                    return false;
                }
            }
            strIndex++;
            patternIndex++;
        }
            if (strIndex < str.length&& patternIndex == pattern.length) {
            return false;
        }
            if (strIndex == str.length && patternIndex == pattern.length) {
            return true;
        }
            return false;*/
    public static void main(String[] args) {
        char[] str = {'h'};
        char[] pattern = {'.'};
        boolean match = match(str, pattern);
        System.out.println(match);
    }
}
