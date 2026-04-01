class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        List<int[]> res = new ArrayList<>();
        res.add(new int[] {intervals[0][0], intervals[0][1]});

        for (int i = 1; i < intervals.length; i++) {
            if (hasOverlap(res.get(res.size() - 1), intervals[i])) {
                var merged = res.get(res.size() - 1);
                var end = Math.max(intervals[i][1], merged[1]);
                merged[1] = end;
            } else {
                res.add(intervals[i]);
            }
        }

        int[][] array = res.toArray(new int[res.size()][]);
        return array;
    }

    private boolean hasOverlap(int[] int1, int[] int2) {
        if (int1[1] >= int2[0]) return true;
        return false;
    }
}
