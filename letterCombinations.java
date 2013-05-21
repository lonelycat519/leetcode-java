/* Given a digit string, return all possible letter combinations that the number could represent.

    A mapping of digit to letters (just like on the telephone buttons) is given below.

    Input:Digit string "23"
    Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"]. */

public class Solution {
    public ArrayList<String> letterCombinations(String digits) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<String> resultList = new ArrayList();
        
        if(digits.length() == 0) {
            resultList.add("");
            return resultList;
        }
        
        String[] dict = {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        StringBuilder sb = new StringBuilder();
        combination(digits, 0, dict, sb, resultList);
        return resultList;
    }
    
    private void combination(String digits, int index, String[] dict, StringBuilder sb, ArrayList<String> resultList) {
        if(index == digits.length()) {
            resultList.add(sb.toString());
            return;
        }
        
        int mapIndex = digits.charAt(index) - '0' -2;
        if(mapIndex<0 || mapIndex>=dict.length)
            return;
        else{
            String letters = dict[mapIndex];
            for(int i=0; i<letters.length(); i++) {
                sb.append(letters.charAt(i));
                combination(digits, index+1, dict, sb, resultList);
                sb.deleteCharAt(sb.length()-1);
            }
        }
    }
}
