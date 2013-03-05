/* Given two sorted integer arrays A and B, merge B into A as one sorted array.
 
 Note:
 You may assume that A has enough space to hold additional elements from B. The number of elements initialized in A and B are m and n respectively. */

public class Solution {
    public void merge(int A[], int m, int B[], int n) {
        for(int i=m+n-1; i>=0; i--){
            if(m>0&n>0){
                if(A[m-1]>=B[n-1]){
                    A[i] = A[m-1];
                    m--;
                }
                else{
                    A[i] = B[n-1];
                    n--;
                }
            }   else if(n>0){
                A[i] = B[n-1];
                n--;
            }
        }
    }
}
