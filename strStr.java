/* Implement strStr().

  Returns a pointer to the first occurrence of needle in haystack, or null if needle is not part of haystack. */

public class Solution {
    public String strStr(String haystack, String needle) {
        if(needle.length()==0) return haystack;
        if(haystack.length()<needle.length())   return null;
        
        for(int i=0; i<haystack.length()-needle.length()+1; i++){
            if(haystack.substring(i, i+needle.length()).equals(needle)){
                return haystack.substring(i);
            }
        }
        
        return null;
    }
}
