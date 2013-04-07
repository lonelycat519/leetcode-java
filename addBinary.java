/* vGiven two binary strings, return their sum (also a binary string).

    For example,
    a = "11"
    b = "1"
    Return "100". */

public class Solution {
    public String addBinary(String a, String b) {
        if(a==null) return b;
        if(b==null) return a;
        
        int len_a = a.length()-1;
        int len_b = b.length()-1;
        
        StringBuffer result = new StringBuffer();
        int carry = 0;
        
        while(len_a>=0 || len_b>=0) {
            int temp = carry;
            if(len_a>=0) temp += a.charAt(len_a--)-'0';
            if(len_b>=0) temp += b.charAt(len_b--)-'0';
            
            if(temp >= 2) {
                temp = temp-2;
                carry = 1;
            } else {
                carry = 0;
            }
            
            result.append(Character.toChars(temp+'0'));
        }
        
        if(carry == 1)
            result.append('1');
        
        result.reverse();   
        
        return result.toString();
    }
}
