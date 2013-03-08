/* Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.
    
    Note:
        Elements in a triplet (a,b,c) must be in non-descending order. (ie, a ≤ b ≤ c)
        The solution set must not contain duplicate triplets.
 
    For example, given array S = {-1 0 1 2 -1 -4},

        A solution set is:
        (-1, 0, 1)
        (-1, -1, 2) */

public class Solution {
    public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
        Arrays.sort(num);
        ArrayList<ArrayList<Integer>> resultList = new ArrayList<ArrayList<Integer>>(); 
        HashSet<ArrayList<Integer>> set = new HashSet<ArrayList<Integer>>();
        
        for(int i=1; i<num.length-1; i++){
            int before = 0;
            int after = num.length-1;
            while(before<i & after>i){
                int sum = num[i]+num[before]+num[after];
                if(sum>0) after--;
                else if(sum<0) before++;
                else{
                    ArrayList<Integer> tempList = new ArrayList<Integer>();
                    tempList.add(num[before]);
                    tempList.add(num[i]);
                    tempList.add(num[after]);
                    if(!set.contains(tempList)){
                        set.add(tempList);
                        resultList.add(tempList);
                    }
                    before++;
                    after--;
                }
            }
        }
        return resultList;
    }
}
