import java.util.ArrayList;

/**
 * @PackageName:PACKAGE_NAME
 * @ClassName:PrintListFromTailToHead_03
 * @Description
 * @Author: yushengbi
 * @Date:2020/2/14 11:12
 */
public class PrintListFromTailToHead_03 {
    ArrayList<Integer> arrayList = new ArrayList<>();

    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        if (listNode != null) {
            printListFromTailToHead(listNode.next);
            arrayList.add(listNode.val);
        }
        return arrayList;
    }
}
