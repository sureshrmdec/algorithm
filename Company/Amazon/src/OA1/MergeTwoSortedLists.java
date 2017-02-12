package OA1;
//Amazon OA
//http://www.lintcode.com/en/problem/merge-two-sorted-lists/
class ListNode {
  int val;
  ListNode next;
  ListNode(int val) {
      this.val = val;
      this.next = null;
  }
}

public class MergeTwoSortedLists {
    /**
     * @param ListNode l1 is the head of the linked list
     * @param ListNode l2 is the head of the linked list
     * @return: ListNode head of linked list
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null && l2 != null)
            return l2;
        else if (l2 == null && l1 != null)
            return l1;
        else if (l1 == null && l2 == null)
            throw new RuntimeException("BAD INPUTS");

        ListNode pointer1 = l1;
        ListNode pointer2 = l2;
        ListNode pre = new ListNode(0);
        pre.next = pointer1.val <= pointer2.val ? pointer1 : pointer2;

        while (pointer1 != null && pointer2 != null) {

            if(pointer1.val <= pointer2.val) {
                pre.next = pointer1;
                pre = pointer1;
                pointer1 = pointer1.next;
            } else {
                pre.next = pointer2;
                pre = pointer2;
                pointer2 = pointer2.next;
            }

        }

        if (pointer1 != null)
            pre.next = pointer1;
        else
            pre.next = pointer2;

        return l1.val <= l2.val ? l1 : l2;
    }
}