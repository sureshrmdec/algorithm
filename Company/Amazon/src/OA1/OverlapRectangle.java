//Amazon OA
package OA1;

public class OverlapRectangle {
    // rectangle A, B
    // time O(1), space O(1)

    public static class Node {
        double x;
        double y;

        public Node(double x, double y) {
            this.x = x;
            this.y = y;
        }
    }


    public static boolean check(Node topLeftA, Node topLeftB, Node bottomRightA, Node bottomRightB) {

        if (bottomRightA.x < topLeftB.x || topLeftA.x > bottomRightB.x) {
            return false;
        }
        // we cannot use "=", because '=' also means overlap.
        if (bottomRightA.y > topLeftB.y || topLeftA.y < bottomRightB.y) {
            return false;
        }

        return true;
    }


}