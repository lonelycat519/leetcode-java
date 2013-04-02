/* Given a collection of intervals, merge all overlapping intervals.

    For example,
    Given [1,3],[2,6],[8,10],[15,18],
    return [1,6],[8,10],[15,18]. */

/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */

public class Solution {
    public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
        if(intervals==null || intervals.isEmpty())
            return intervals;
        
        class Com implements Comparator<Interval>{
            public int compare(Interval i1, Interval i2){
                if(i1.start<i2.start)
                    return -1;
                else if(i1.start>i2.start)
                    return 1;
                else{
                    if(i1.end<i2.end)
                        return -1;
                    else if(i1.end>i2.end)
                        return 1;
                    else
                        return 0;
                }
            }
        }
        
        
        Collections.sort(intervals, new Com());
        
        ArrayList<Interval> resultList = new ArrayList<Interval>();
        for(int i=0; i<intervals.size(); i++){
            if(resultList.isEmpty())
                resultList.add(intervals.get(i));
            else{
                Interval cur = intervals.get(i);
                Interval last = resultList.get(resultList.size()-1);
                if(cur.start<=last.end){
                    if(cur.end>=last.end)
                        last.end = cur.end;
                }
                else
                    resultList.add(cur);
            }
        }
        
        return resultList;
    }
}
