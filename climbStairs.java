public class Solution {
    public int climbStairs(int n) {
        if(n<=2) return n;
        
        int step_n1 = 1;
        int step_n2 = 2;
        
        for(int i=3; i<=n; i++){
            int temp = step_n2;
            step_n2 = temp + step_n1;
            step_n1 = temp;
        }
        
        return step_n2;
    }
}
