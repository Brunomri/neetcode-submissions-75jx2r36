class Solution {
    public int maxArea(int[] heights) {
        int maxArea = 0;
        /* Use two pointer technique to start searching meaninful solutions
        starting with maximum container width */
        int left = 0, right = heights.length - 1;

        while(left < right) {
            /* Calculate the current area and update the max area if needed */
            int area = Math.min(heights[left], heights[right]) * (right - left);
            maxArea = area > maxArea ? area : maxArea;
            
            /* Since the height is limited by the shorter bar, to potentially
            increase the area, we must move the pointer of the shorter bar inward */
            if(heights[left] < heights[right]) left++;
            else right--;
        }

        return maxArea;
    }
}
