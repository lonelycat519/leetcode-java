/* A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).

  The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).

  How many possible unique paths are there? */



public class Solution {
    public int uniquePaths(int m, int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int[][] map = new int[m+2][n+2];
        map[m][n+1] = 1;
        
        for(int i=m; i>=1; i--) {
            for(int j=n; j>=1; j--) {
                map[i][j] = map[i+1][j]+map[i][j+1];
            }
        }
        
        return map[1][1];
    }
}
