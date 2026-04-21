class Solution {
    public int maxArea(int[] heights) {
        int maxArea = 0;
        int left = 0, right = heights.length - 1;

        while(left < right) {
            int area = getArea(left, heights[left], right, heights[right]);
            maxArea = area > maxArea ? area : maxArea;
            
            if(heights[left] < heights[right]) left++;
            else right--;
        }

        return maxArea;
    }

    private int getArea(int leftX, int leftY, int rightX, int rightY) {
        int deltaX = rightX - leftX;
        int y = Math.min(leftY, rightY);
        return deltaX * y;
    }
}
