/**
 * @author bys
 * @date 2020-01-03 21:12
 */
public class DeleteDuplication_57 {
    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode deleteDuplication(ListNode pHead) {
        if (pHead == null || pHead.next == null) {
            return pHead;
        }

        //加一个头结点
        ListNode Head = new ListNode(0);
        Head.next = pHead;
        //cur为工作指针，pre指向不重复的结点/前一个结点
        ListNode cur = Head.next;
        ListNode pre = Head;
        while (cur != null) {
            //当前节点和下一节点的数值相同
            if (cur.next != null && cur.val == cur.next.val) {
                //因为重复的节点可能有多个，循环直到最后一个
                while (cur.next != null && cur.val == cur.next.val) {
                    cur = cur.next;
                }
                pre.next = cur.next;
                cur = cur.next;
            } else {
                pre = pre.next;
                cur = cur.next;
            }
        }
        return Head.next;
    }

}
