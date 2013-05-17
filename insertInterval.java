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
    public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int size = intervals.size();
        boolean added = false;
        ArrayList<Interval> resultList = new ArrayList<Interval>();
        
        if(size == 0) {
            resultList.add(newInterval);
            added = true;
        }
        
        for(int i=0; i<size; i++) {
            int start = intervals.get(i).start;
            int end = intervals.get(i).end;
            
            if(start > newInterval.end) {
                resultList.add(newInterval);
                //newInterval.start = intervals.get(size-1).start;
                //newInterval.end = intervals.get(size-1).end;
                added = true;
                while(i<size) {
                    resultList.add(intervals.get(i++));
                }
            } else if(end < newInterval.start) {
                resultList.add(intervals.get(i));
            } else {
                newInterval.start = Math.min(newInterval.start, start);
                newInterval.end = Math.max(newInterval.end, end);
            }  
        }
        
        if(!added)
            resultList.add(newInterval);
            
        return resultList;
    }
}
