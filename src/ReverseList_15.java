/**
 * @PackageName:PACKAGE_NAME
 * @ClassName:ReverseList_15
 * @Description
 * @Author: yushengbi
 * @Date:2020/2/17 13:32
 */
public class ReverseList_15 {
    public static ListNode ReverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode pre = head, cur = head;
        ListNode next = null;

        next = cur.next;
        cur.next = null;
        cur = next;

        while (cur != null) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(2);
        node.next = new ListNode(3);
        node.next.next = new ListNode(4);
        node.next.next.next = new ListNode(5);
        node.next.next.next.next = new ListNode(6);
        node.next.next.next.next.next = new ListNode(7);
        node.next.next.next.next.next.next = new ListNode(8);
        ListNode reverseList = ReverseList(node);
        while (reverseList != null) {
            System.out.printf(reverseList.val + "->");
            reverseList = reverseList.next;
        }

    }
}
