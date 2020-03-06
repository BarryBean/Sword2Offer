/**
 * @author bys
 * @date 2020-01-03 14:35
 */
public class EntryNodeOfLoop_55 {
    public ListNode EntryNodeOfLoop(ListNode pHead) {
        if (pHead == null || pHead.next == null || pHead.next.next == null) {
            return null;
        }
        //这里也可以直接设置为pHead
        ListNode slow = pHead.next;
        ListNode fast = pHead.next.next;

        while (slow != fast) {
            //这种情况认为无环结构
            if (fast.next == null || fast.next.next == null) {
                return null;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        //当快慢指针会合，认为有环
        fast = pHead;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}
