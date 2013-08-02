/* Follow up for "Unique Paths":

    Now consider if some obstacles are added to the grids. How many unique paths would there be?
    
    An obstacle and empty space is marked as 1 and 0 respectively in the grid.
    
    For example,
    
    There is one obstacle in the middle of a 3x3 grid as illustrated below.
    
    [
      [0,0,0],
      [0,1,0],
      [0,0,0]
    ]
    The total number of unique paths is 2.
    
    Note: m and n will be at most 100. */

public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int n = obstacleGrid.length;
        int m = obstacleGrid[0].length;
        
        int[][] map = new int[n+1][m+1];
        
        map[n-1][m] = 1;
        
        for(int j=m-1; j>=0; j--) {
            for(int i=n-1; i>=0; i--) {
                if(j==m-1||i==n-1) {
                    if(obstacleGrid[i][j]==1)
                        map[i][j] = 0;
                    else    
                        map[i][j] = map[i+1][j] + map[i][j+1];
                } else {
                    if(obstacleGrid[i][j]==1)
                        map[i][j] = 0;
                    else {
                        if(obstacleGrid[i][j+1]==1) {
                            if(obstacleGrid[i+1][j]==1)
                                map[i][j] = 0;
                            else
                                map[i][j] = map[i+1][j];
                        } else {
                            if(obstacleGrid[i+1][j]==1)
                                map[i][j] = map[i][j+1];
                            else
                                map[i][j] = map[i+1][j] + map[i][j+1];
                        }
                    }
                }
            }
        }
        
        return map[0][0]==-1?0:map[0][0];
    }
}
