class Solution {
    public int[][] merge(int[][] intervals) {
        /* Sort the intervals by starting time */
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        int lastMergedIdx = 0;
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[lastMergedIdx][1] >= intervals[i][0]) {
                intervals[lastMergedIdx][1] = Math.max(intervals[lastMergedIdx][1], intervals[i][1]);
            } else {
                lastMergedIdx++;
                intervals[lastMergedIdx] = intervals[i];
            }
        }

        return Arrays.copyOf(intervals, lastMergedIdx + 1);
    }
}