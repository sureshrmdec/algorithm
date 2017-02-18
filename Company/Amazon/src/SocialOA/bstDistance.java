package SocialOA;
/*
Given a list of unique integers, construct the binary tree by given order without rebalancing,
then find out the distance between two nodes.
reference: http://algorithms.tutorialhorizon.com/find-the-distance-between-two-nodes-of-a-binary-tree/
*/
class Nodee {
    int val;
    Nodee left;
    Nodee right;

    public Nodee(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }
}

public class bstDistance {

    public static int findDistance(Nodee root, Nodee n1, Nodee n2) {
        int n1Distance = Pathlength(root, n1);
        int n2Distance = Pathlength(root, n2);
        Nodee ancester = lowestCommonAncestor(root, n1, n2);
        int ancesterDistance = Pathlength(root, ancester);
        return (n1Distance + n2Distance) - 2 * ancesterDistance;
    }

    private static int Pathlength(Nodee root, Nodee dest) {
        int steps = 0;

        while (root != null && root.val != dest.val) {
            if (root.val > dest.val)
                root = root.left;
            else
                root = root.right;
            steps++;
        }
        // make sure we really found the dest node before we return the steps
        if (root != null && root.val == dest.val)
            return steps;
        else
            return 0;
    }

    private static Nodee lowestCommonAncestor(Nodee root, Nodee A, Nodee B) {
        if (root == null || root == A || root == B)
            return root;
        Boolean found[] = new Boolean[1];
        found[0] = false;

        Nodee res = helper(root, A, B, found);
        if(found[0])
            return res;
        else
            return null;

    }

    private static Nodee helper(Nodee root, Nodee A, Nodee B, Boolean[] found) {
        if (root == null)
            return null;

        Nodee leftRes = helper(root.left, A, B, found);
        Nodee rightRes = helper(root.right, A, B, found);

        if (leftRes != null && rightRes != null) {
            found[0] = true;
            return root;
        }
        // one node is another node's parent
        else if (((leftRes != null && rightRes == null) || (leftRes == null && rightRes != null)) && (root == A || root == B)) {
            found[0] = true;
            return root;
        }
        else if (leftRes != null)
            return leftRes;
        else if (rightRes != null)
            return rightRes;
            //general case, found A or B in current node, but doesn't find A or B in children.
        else if ((leftRes == null && rightRes == null) && (root == A || root == B))
            return root;
        else
            return null;
    }
    
    public static Nodee insertNode(Nodee root, Nodee node) {
        if (root == null)
            return node;

        Nodee cur = root;
        Nodee parent = null;
        while (cur != null) {
            parent = cur;
            if (cur.val < node.val)
                cur = cur.right;
            else if (cur.val > node.val)
                cur = cur.left;
        }

        if (parent.val > node.val)
            parent.left = node;
        else
            parent.right = node;
        return root;
    }
    
    public static void main(String[] args) {

        int[] testArray = {10, 25, 35, 5, 12, 27, 18, 6, 33, 22, 11};
        Nodee root = new Nodee(testArray[0]);

        Nodee n1 = null, n2 = null;
        for (int i = 1; i < testArray.length; i++) {
            Nodee newNode = new Nodee(testArray[i]);
            if (newNode.val == 22)
                n1 = newNode;
            else if (newNode.val == 33)
                n2 = newNode;
            insertNode(root, newNode);
        }
        
        int res = findDistance(root, n1, n2);
        System.out.print(res); //4

    }

}
