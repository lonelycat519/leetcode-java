/* Given a roman numeral, convert it to an integer.

    Input is guaranteed to be within the range from 1 to 3999. */

public class Solution {
    public int romanToInt(String s) {
        if(s==null || s.length()==0)
            return 0;
        
        // Build Roman to Arabic map
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        
        // Calculate number
        int len = s.length();
        int result = map.get(s.charAt(len-1));
        for(int i=len-1; i>=1; i--){
            if(map.get(s.charAt(i-1))>=map.get(s.charAt(i)))
                result += map.get(s.charAt(i-1));
            else
            result -= map.get(s.charAt(i-1));
        }
        return result;
    }
}
