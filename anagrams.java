/* Given an array of strings, return all groups of strings that are anagrams.

  Note: All inputs will be in lower-case. */

public class Solution {
    public String getStr(String s){
        char[] array = s.toCharArray();
        Arrays.sort(array);
        return new String(array);
    }
    
    public ArrayList<String> anagrams(String[] strs) {
        int len = strs.length;
        ArrayList<String> result = new ArrayList<String>();
        HashMap<String, Integer> hash = new HashMap<String, Integer>();
        
        if(len==0)  return result;
        
        for(int i=0; i<len; i++){
            String temp = getStr(strs[i]);
            if(hash.containsKey(temp))
                hash.put(temp, hash.get(temp)+1);
            else
                hash.put(temp, 1);
        }
        
        for(int i=0; i<len; i++){
            String temp = getStr(strs[i]);
            if(hash.containsKey(temp) && hash.get(temp)>=2)
                result.add(strs[i]);
        }
        
        return result;
    }
}
