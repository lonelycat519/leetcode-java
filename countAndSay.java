/* The count-and-say sequence is the sequence of integers beginning as follows:
      1, 11, 21, 1211, 111221, ...
  
      1 is read off as "one 1" or 11.
      11 is read off as "two 1s" or 21.
      21 is read off as "one 2, then one 1" or 1211.

    Given an integer n, generate the nth sequence.
    
    Note: The sequence of integers will be represented as a string. */


public class Solution {
    public String countAndSay(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(n <= 0)
            return null;
        
        String result = "1";
        while(n>1) {
            result = countAndSay(result);
            n--;
        }
        return result;
    }
    
    private String countAndSay(String s) {
        int len = s.length();
        StringBuffer result = new StringBuffer();
        
        int count = 1;
        char ch = s.charAt(0);
        for(int i=1; i<len; i++) {
            if(ch == s.charAt(i)) {
                count++;
            } else {
                result.append(count);
                result.append(ch);
                ch = s.charAt(i);
                count = 1;
            }
        }
        
        result.append(count);
        result.append(ch);
        
        return result.toString();
    }
}
