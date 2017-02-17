package SocialOA;
import java.util.*;
// Amazon Social OA, VIP
/*
Find the min steps of maze 意思是说有一个M*N的maze，0代表可以通过，1代表不可以通过，然后给你一个出口（x,y），
找从（0,0）到出口的最少steps，如果找不到path就返回-1

*/
class Node {
    int x;
    int y;
    int val;
    Node(int x, int y, int val) {
        this.x = x;
        this.y = y;
        this.val = val;
    }
}

public class Maze {
    private final static int[] dx = {-1, 0, 0, 1};
    private final static int[] dy = {0, 1, -1, 0};
    public static int findMinSteps(int[][] matrix, int desX, int desY) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return 0;
        if (matrix[0][0] == 9)
            return 1;

        int row = matrix.length, col = matrix[0].length;
        boolean[][] visited = new boolean[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                visited[i][j] = false;
            }
        }

        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(0 ,0 ,0));
        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            for (int i = 0; i < 4; i++) {
                int adjX = cur.x + dx[i];
                int adjY = cur.y + dy[i];
                if ((adjX >= 0) && (adjX < row) && (adjY >= 0) && (adjY < col) && !visited[adjX][adjY]
                        && matrix[adjX][adjY] != 1) {
                    if (adjX == desX && adjY == desY) {
                        return ++cur.val;
                    } else {
                        Node adjacent = new Node(cur.x + dx[i], cur.y + dy[i], cur.val + 1);
                        visited[adjX][adjY] = true;
                        queue.offer(adjacent);
                        /* if you want print the path, you have to record each node's parent, and use a recursion function to print the path
                            map.put(adjacent, cur);
                         */
                    }

                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[][] matrix = {  {0,0,1,0,0},
                            {0,1,0,1,0},
                            {0,0,0,1,0},
                            {0,0,0,0,0}
                         };

        int steps = findMinSteps(matrix, 1, 2);
        System.out.print(steps);
    }
}
