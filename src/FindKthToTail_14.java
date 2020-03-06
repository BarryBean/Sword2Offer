/**
 * @PackageName:PACKAGE_NAME
 * @ClassName:FindKthToTail_14
 * @Description
 * @Author: yushengbi
 * @Date:2020/2/17 13:20
 */
public class FindKthToTail_14 {
    public static ListNode FindKthToTail(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        ListNode fast = head, slow = head;
        while (k != 0) {
            if (fast == null) {
                return null;
            }
            fast = fast.next;
            k--;
        }
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }


    public static void main(String[] args) {
        ListNode node = new ListNode(2);
        node.next = new ListNode(3);
        node.next.next = new ListNode(4);
        node.next.next.next = new ListNode(5);
        node.next.next.next.next = new ListNode(6);
        node.next.next.next.next.next = new ListNode(7);
        node.next.next.next.next.next.next = new ListNode(8);
        System.out.println(FindKthToTail(node, 3).val);
    }
}
