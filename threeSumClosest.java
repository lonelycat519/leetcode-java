/* Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target. Return the sum of the three integers. You may assume that each input would have exactly one solution.
 
    For example, given array S = {-1 2 1 -4}, and target = 1.
 
    The sum that is closest to the target is 2. (-1 + 2 + 1 = 2). */

public class Solution {
    public int threeSumClosest(int[] num, int target) {
        Arrays.sort(num);
        
        int sum = num[0] + num[1] + num[num.length-1];
        
        for(int i=0; i<num.length-2; i++){
            int p = i+1;
            int q = num.length-1;
            
            while(p!=q){
                int temp = num[i] + num[p] + num[q];
                
                if(temp == target)
                    return target;
                else{
                    if(temp>target)
                        q--;
                    else
                        p++;
                    if(Math.abs(temp-target) <= Math.abs(sum-target))
                        sum = temp;
                }
            }
        }
        
        return sum;
    }
}
