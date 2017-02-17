package Test;

/**
 * Created by MikeZhou1 on 2/16/17.
 */
public class Solution {
    /**
     * @param obstacleGrid: A list of lists of integers
     * @return: An integer
     */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid.length == 0 || obstacleGrid == null)
            return 0;

        int row = obstacleGrid.length;
        int col = obstacleGrid[0].length;

        int[][] sum = new int[row][col];

        for (int i = 0; i < row; i++) {
            if(obstacleGrid[i][col-1] == 1)
                sum[i][col-1] = 0;
            else
                sum[i][col-1] = 1;
        }

        for (int i = 0; i < col; i++) {
            if(obstacleGrid[row-1][i] == 1)
                sum[row-1][i] = 0;
            else
                sum[row-1][i] = 1;
        }

        for (int i = 1; i < col; i++) {
            for (int j  = 1; j < row; j++) {
                if (obstacleGrid[i][j] == 1)
                    sum[i][j] = 0;
                else
                    sum[i][j] = sum[i-1][j] + sum[j-1][i];
            }
        }

        return sum[row-1][col-1];
    }
}