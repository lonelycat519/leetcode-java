/* Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai). n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis forms a container, such that the container contains the most water.
 
    Note: You may not slant the container. */

public class Solution {
    public int maxArea(int[] height) {
        int len = height.length;
        int s = 0;
        int i = 0;
        int j = len-1;
        
        while(i!=j){
            int a = j - i;
            // Get height of the container.
            int h=(height[i]<height[j])?height[i++]:height[j--];
            // Calculate S.
            if(s<a*h)  s = a*h;
        }
        
        return s;
    }
}
