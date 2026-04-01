class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> result = new ArrayList();
        /* Sort the intervals by starting time */
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        for (int i = 0; i < intervals.length; i++) {
            if (result.size() == 0) {
                /* Initialize the result with the first interval */
                var first = new int[2];
                first[0] = intervals[0][0];
                first[1] = intervals[0][1];
                result.add(first);
            } else {
                var lastInterval = result.getLast();
                /* If the last interval in the result overlaps the current interval */
                if (hasOverlap(lastInterval[0], lastInterval[1], intervals[i][0], intervals[i][1])) {
                    int[] newInterval = new int[2];
                    /* Merge the current interval into the last interval in the result by updating its ending time if
                    the ending time of the current interval is later, otherwise remains the same */
                    newInterval[0] = lastInterval[0];
                    newInterval[1] = intervals[i][1] > lastInterval[1] ? intervals[i][1] : lastInterval[1];
                    result.removeLast();
                    result.add(newInterval);
                /* If there is no overlap, just adds the current interval to the results */
                } else {
                    var latest = new int[2];
                    latest[0] = intervals[i][0];
                    latest[1] = intervals[i][1];
                    result.add(latest);
                }
            }
        }

        return result.toArray(new int[0][]);
    }

    /* After sorting by starting time, we know two intervals overlap
    if the first interval ends after the second interval starts */
    private boolean hasOverlap(int start1, int end1, int start2, int end2) {
        if (end1 >= start2) {
            System.out.println("merging [%s, %s] and [%s, %s]".formatted(start1, end1, start2, end2));
            return true;
        }
        return false;
    }
}