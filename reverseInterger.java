/* Reverse digits of an integer.

  Example1: x = 123, return 321
  Example2: x = -123, return -321 */

public class Solution {
    public int reverse(int x) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(x==0)
            return 0;
        
        int sign = x>0? 1: -1;
        int result = 0;
        
        x = Math.abs(x);
        while(x>0) {
            result = (result*10) + (x%10);
            x = x/10;
        }
        
        return result * sign;
    }
}
