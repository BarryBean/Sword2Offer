/**
 * @PackageName:PACKAGE_NAME
 * @ClassName:Merge_16
 * @Description
 * @Author: yushengbi
 * @Date:2020/2/17 14:13
 */
public class Merge_16 {
    public static ListNode Merge(ListNode list1, ListNode list2) {
        if (list1 == null || list2 == null) {
            return list1 == null ? list2 : list1;
        }

        ListNode head = new ListNode(0);
        head.next = null;
        ListNode root = head;

        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                head.next=list1;
                head=head.next;
                list1=list1.next;
            } else {
                head.next=list2;
                head=head.next;
                list2=list2.next;
            }
        }
        if (list1 != null) {
            head.next = list1;
        }
        if (list2 != null) {
            head.next = list2;
        }
        return root.next;
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.next = new ListNode(4);
        node.next.next = new ListNode(8);
        node.next.next.next = new ListNode(10);
        //node.next.next.next.next = new ListNode(6);
        //node.next.next.next.next.next = new ListNode(7);
        //node.next.next.next.next.next.next = new ListNode(8);
        ListNode node2 = new ListNode(2);
        node2.next = new ListNode(3);
        node2.next.next = new ListNode(6);

        ListNode list = Merge(node, node2);
        while (list != null) {
            System.out.printf(list.val + "->");
            list = list.next;
        }
    }
}
