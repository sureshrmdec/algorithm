//Amazon OA2
//https://segmentfault.com/a/1190000007065158
package OA1;
import java.util.*; //这次差点儿忘了这个

class Node { //这个是题目给好的
    int val;
    ArrayList<Node> children;
    public Node(int val){
        this.val = val;
        children = new ArrayList<Node>();
    }
}
class SumCount {
    int sum;
    int count;
    public SumCount(int sum, int count) {
        this.sum = sum;
        this.count = count;
    }
}



public class CompanyTree {

    private static double resAve = Double.MIN_VALUE;  //we use public variable to store max/min value
    private static Node result; //we use public variable to keep tracking the node we want to find, instead of passing
                                //this node all the way up

    public static Node getHighAve(Node root){
        if (root == null) return null;
        postOrder(root);
        return result;

    }

    private static SumCount postOrder(Node mid) {
        if (mid.children == null || mid.children.size() == 0) {
            return new SumCount(mid.val, 1);
        } //base case is the leaf node, instead of the null node.
        /*
        if (mid.child == null)
            return new SumCount(0, 0);
         */

        int sumChildren = 0, countChildren = 0;
        for (Node child : mid.children) {
            SumCount childNode = postOrder(child);
            sumChildren += childNode.sum;
            countChildren += childNode.count;
        } // time complexity is O(N), each node is reached just once

        SumCount resSumCount = new SumCount(sumChildren + mid.val, countChildren + 1);
        double midAve = (double)resSumCount.sum / resSumCount.count;
        if (midAve > resAve) {
            result = mid;
            resAve = midAve;
        }

        return resSumCount;
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        Node l21 = new Node(2);
        Node l22 = new Node(3);
        Node l23 = new Node(4);
        Node l31 = new Node(5);
        Node l32 = new Node(5);
        Node l33 = new Node(5);
        Node l34 = new Node(5);
        Node l35 = new Node(5);
        Node l36 = new Node(5);

        l21.children.add(l31);
        l21.children.add(l32);

        l22.children.add(l33);
        l22.children.add(l34);

        l23.children.add(l35);
        l23.children.add(l36);

        root.children.add(l21);
        root.children.add(l22);
        root.children.add(l23);

        Node res = getHighAve(root);
        System.out.println(res.val + " " + resAve);
    }
}
