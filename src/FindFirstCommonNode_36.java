/**
 * @author bys
 * @date 2019-11-17 15:45
 */

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}

public class FindFirstCommonNode_36 {
    public static ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        if (pHead1 == null || pHead2 == null) {
            return null;
        }
        int len1 = getListLength(pHead1);
        int len2 = getListLength(pHead2);

        int dist = Math.abs(len1-len2);
        ListNode curA = pHead1, curB = pHead2;

        //A放长，B放短
        curA = len1 >= len2 ? pHead1 : pHead2;
        curB = curA == pHead1 ? pHead2 : pHead1;

        while (dist-- != 0) {
            curA = curA.next;
        }
        while (curA != curB) {
            curA = curA.next;
            curB = curB.next;
        }
        return curA;
    }

    public static int getListLength(ListNode p) {
        int sum = 1;
        if (p.next == null) {
            return 0;
        }
        while (p.next != null) {
            p = p.next;
            sum++;
        }
        return sum;
    }

    public static ListNode runFirstDist(ListNode p, int dist) {
        while (p.next != null && dist != 0) {
            p = p.next;
            dist--;
        }
        return p;
    }
}
