class Solution {

    public record Bar(int x, int y) {};

    public int maxArea(int[] heights) {
        int maxArea = 0;

        for(int i = 0; i < heights.length; i++) {
            for(int j = i; j < heights.length; j++) {
                Bar leftBar = new Bar(i, heights[i]);
                Bar rightBar = new Bar(j, heights[j]);
                int area = getArea(leftBar, rightBar);
                maxArea = area > maxArea ? area : maxArea;
            }
        }

        return maxArea;
    }

    private int getArea(Bar leftBar, Bar rightBar) {
        int deltaX = rightBar.x() - leftBar.x();
        int y = Math.min(leftBar.y(), rightBar.y());
        return deltaX * y;
    }
}
