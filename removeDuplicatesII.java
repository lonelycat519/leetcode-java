/* Follow up for "Remove Duplicates":
     What if duplicates are allowed at most twice?
     
     For example,
     Given sorted array A = [1,1,1,2,2,3],
     
     Your function should return length = 5, and A is now [1,1,2,2,3]. */

public class Solution {
    public int removeDuplicates(int[] A) {
        int len = A.length;
        
        if(len<3)  return len;
        
        int[] dup = {A[0], 1};
        int num = 0;
        int next = 1;
        for( ; next<len; next++){
            if(A[next]==dup[0]){
                if(dup[1]==1){
                    dup[1]++;
                    A[++num] = A[next];
                }
                else if(dup[1]>=2){
                    dup[1]++;
                }
            }   else{
                dup[0] = A[next];
                dup[1] = 1;
                A[++num] = A[next];
            }
        }
        return num+1;
    }
}
