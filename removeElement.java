/* Given an array and a value, remove all instances of that value in place and return the new length.
 
 The order of elements can be changed. It doesn't matter what you leave beyond the new length. */

public class Solution {
    public int removeElement(int[] A, int elem) {
        Arrays.sort(A);
        
        int now = 0;
        int after = 0;
        boolean find = false;
        boolean fin = false;
        
        for(int i=0; i<A.length; i++){
            if(A[i]==elem){
                now=i;
                find = true;
                break;
            }
        }
        
        if(find)
            for(int i=now+1; i<A.length; i++){
                if(A[i]!=elem){
                    after = i;
                    fin = true;
                    break;
                }
            }
        
        if(!fin)
            after = A.length;
        
        if(!find)   return A.length;
        else{
            int len = A.length-(after-now);
            for(; after<A.length;)
                A[now++]=A[after++];
            
            return len;
        }
    }
}
