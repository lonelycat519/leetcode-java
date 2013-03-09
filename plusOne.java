/* Given a number represented as an array of digits, plus one to the number. */

public class Solution {
    public int[] plusOne(int[] digits) {
        int len = digits.length;
        
        // Array has no element
        if(len==0){
            int[] result = new int[1];
            result[0] = 1;
            return result;
        }
        
        // General situation
        digits[len-1] += 1;
        for(int i=len-1; i>0; i--){
            if(digits[i]>=10){
                digits[i] %= 10;
                digits[i-1] += 1;
            }   else
                break;
        }
        
        // Taking care of the carry for the highest digit
        if(digits[0]<10)
            return digits;
        else{
            int[] result = new int[len+1];
            result[0] = 1;
            for(int i=0; i<len; i++)
                result[i+1] = digits[i]%10;
            return result;
        }
    }
}
