class Solution {
    /* Reuse the input array for merging results */
    public int[][] merge(int[][] intervals) {
        /* Sort the intervals by starting time */
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        /* Track the index the last merged interval */
        int lastMergedIdx = 0;
        for (int i = 1; i < intervals.length; i++) {
            /* Check if intervals overlap */
            if (intervals[lastMergedIdx][1] >= intervals[i][0]) {
                /* The latest end time is chosen for the merged interval */
                intervals[lastMergedIdx][1] = Math.max(intervals[lastMergedIdx][1], intervals[i][1]);
            } else {
                /* In case there is no overlap, the current interval is stored and
                the index is updated to the next interval */
                lastMergedIdx++;
                intervals[lastMergedIdx] = intervals[i];
            }
        }

        /* Return only the merged part */
        return Arrays.copyOf(intervals, lastMergedIdx + 1);
    }
}