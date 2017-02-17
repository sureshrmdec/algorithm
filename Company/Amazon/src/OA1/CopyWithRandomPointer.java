//Amazon OA
//http://www.lintcode.com/en/problem/copy-list-with-random-pointer/
package OA1;
import java.util.*;

class RandomListNode {
    int label;
    RandomListNode next, random;
    RandomListNode(int x) {
        this.label = x;
    }
}


public class CopyWithRandomPointer {
    /**
     * @param head: The head of linked list with a random pointer.
     * @return: A new head of a deep copy of the list.
     */

    /*
    public RandomListNode copyRandomList(RandomListNode head) {
        // special cases
        if (head == null)
            return null;

        if (head.next == null) {
            RandomListNode newNode = new RandomListNode(head.label);
            newNode.next = head.next;
            newNode.random = head.random;
            return newNode;
        }


        RandomListNode pre = head;
        RandomListNode pos = null;

        //step 1: insert a new node between two old nodes
        while (pre != null) {
            RandomListNode newNode = new RandomListNode(pre.label);
            pos = pre.next;
            pre.next = newNode;
            newNode.next = pos;
            newNode.label = pre.label;
            pre = pos;
        }
        pre = head;

        //step 2: assign random pointer value to new nodes
        while (pre != null) {
            if (pre.random != null) {
                pre.next.random = pre.random.next;

            } else {
                pre.next.random = null;
            }
            pre = pre.next.next;
        }

        //step 3; recover original list and reconnect new list
        pre = head;
        pos = head.next.next;
        RandomListNode newHead = head.next;
        while (pre != null) {
            if (pre.next.next != null) {
                pre.next.next = pos.next;
                pre.next = pos;
                pre = pos;
                pos = pos.next.next;
            } else {  //for the last node
                pre.next.next = null;
                pre.next = null;
                pre = null;

            }
        }

        return newHead;
    }
    */

    //we better choose hashmap version, because we don't need to care too much with edges cases anymore, current is the king.
    //HashMap version
    public RandomListNode copyRandomList(RandomListNode head) {
        // write your code here
        if (head == null)
            return null;

        HashMap<RandomListNode, RandomListNode> map = new HashMap<>();

        RandomListNode oldHead = head;
        RandomListNode dummy = new RandomListNode(0);
        RandomListNode pre = dummy;
        RandomListNode newHead = null;


        while (oldHead != null) {
            newHead = new RandomListNode(oldHead.label);
            map.put(oldHead, newHead);
            newHead.random = oldHead.random;
            pre.next = newHead;
            pre = newHead;
            oldHead = oldHead.next;
        }

        newHead = dummy.next;

        while (newHead != null) {
            if(newHead.random != null) // for the case that random points to null
                newHead.random = map.get(newHead.random);
            else
                newHead.random = null;
            newHead = newHead.next;
        }

        return dummy.next;
    }

}