/**
 * @PackageName:PACKAGE_NAME
 * @ClassName:ReplaceSpace_02
 * @Description
 * @Author: yushengbi
 * @Date:2020/2/13 23:41
 */
public class ReplaceSpace_02 {
    public String replaceSpace(StringBuffer str) {
        int spaceNum=0;
        for (int i = 0; i < str.length(); i++) {
            if(str.charAt(i)==' '){
                spaceNum++;
            }
        }
        int indexOld=str.length()-1;
        int lengthNew=str.length()+spaceNum*2;
        int indexNew =lengthNew-1;
        str.setLength(lengthNew);
        while (indexOld>=0 && indexOld<lengthNew){
            if(str.charAt(indexOld)==' '){
                str.setCharAt(indexNew--,'0');
                str.setCharAt(indexNew--,'2');
                str.setCharAt(indexNew--,'%');
            }else {
                str.setCharAt(indexNew--,str.charAt(indexOld));
            }
            indexOld--;
        }
        return str.toString();
    }
}
