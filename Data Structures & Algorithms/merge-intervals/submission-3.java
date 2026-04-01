class Solution {
    public int[][] merge(int[][] intervals) {
        /* Sort the intervals by starting time */
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        List<int[]> res = new ArrayList<>();
        /* Initialize the result with the first interval */
        res.add(new int[] {intervals[0][0], intervals[0][1]});

        for (int i = 1; i < intervals.length; i++) {
            /* If the latest interval in the result overlaps the current interval */
            if (hasOverlap(res.get(res.size() - 1), intervals[i])) {
                /* Merge the current interval into the last interval in the result by updating its ending time if
                the ending time of the current interval is later, otherwise remains the same */
                var merged = res.get(res.size() - 1);
                var end = Math.max(intervals[i][1], merged[1]);
                merged[1] = end;
            } else {
                /* If there is no overlap, just adds the current interval to the results */
                res.add(intervals[i]);
            }
        }

        int[][] array = res.toArray(new int[res.size()][]);
        return array;
    }

    /* After sorting by starting time, we know two intervals overlap
    if the first interval ends after the second interval starts */
    private boolean hasOverlap(int[] int1, int[] int2) {
        if (int1[1] >= int2[0]) return true;
        return false;
    }
}
