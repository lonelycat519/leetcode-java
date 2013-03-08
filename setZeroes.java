/* Given a m x n matrix, if an element is 0, set its entire row and column to 0. 
    Do it in place. */

public class Solution {
    public void setZeroes(int[][] matrix) {
        int row = matrix.length;
        if(row==0)  return;
        int column = matrix[0].length;
        if(column==0)   return;
        
        // Check if first row & column contain zeros
        boolean rowIsZero = false;
        boolean columnIsZero = false;
        for(int i=0; i<row; i++){
            if(matrix[i][0]==0){
                rowIsZero = true;
                break;
            }
        }
        for(int j=0; j<column; j++){
            if(matrix[0][j]==0){
                columnIsZero = true;
                break;
            }
        }
        
        // Check zeros in matrix
        for(int i=1; i<row; i++)
            for(int j=1; j<column; j++){
                if(matrix[i][j]==0){
                    matrix[i][0]=0;
                    matrix[0][j]=0;
                }
            }
        
        // Set matrix to zeros
        for(int i=1; i<matrix.length; i++){
            if(matrix[i][0]==0){
                for(int j=1; j<matrix[0].length; j++)
                    matrix[i][j]=0;
            }
        }
        for(int j=1; j<matrix[0].length; j++){
            if(matrix[0][j]==0){
                for(int i=1; i<matrix.length; i++)
                    matrix[i][j]=0;
            }
        }
        
        // Set first row & column to zeros
        if(rowIsZero)
            for(int i=0; i<matrix.length; i++)
                matrix[i][0] = 0;
        if(columnIsZero)
            for(int j=0; j<matrix[0].length; j++)
                matrix[0][j] = 0;
    }
}

