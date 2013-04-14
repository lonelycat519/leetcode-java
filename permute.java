/* Given a collection of numbers, return all possible permutations.
    
    For example,
    [1,2,3] have the following permutations:
    [1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], and [3,2,1]. */

public class Solution {
    public ArrayList<ArrayList<Integer>> permute(int[] num) {
        if(num.length==0)   return new ArrayList<ArrayList<Integer>>();
        
        ArrayList<ArrayList<Integer>> resultList = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> result = new ArrayList<Integer>();
        result.add(num[0]);
        resultList.add(result);
        
        for(int i=1; i<num.length; i++) {
            resultList = insert(resultList, num[i]);
        }
        
        return resultList;
    }
    
    private ArrayList<ArrayList<Integer>> insert(ArrayList<ArrayList<Integer>> list, int num) {
        ArrayList<ArrayList<Integer>> resultList = new ArrayList<ArrayList<Integer>>();
        
        for(int i=0; i<list.size(); i++) {
            for(int j=0; j<list.get(i).size()+1; j++) {
                ArrayList<Integer> result = new ArrayList<Integer>(list.get(i));
                result.add(j, num);
                resultList.add(result);
            }
        }
        
        return resultList;
    }
}
