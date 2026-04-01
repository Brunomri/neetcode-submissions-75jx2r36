class Solution {
    public int longestConsecutive(int[] nums) {
        var set = Arrays.stream(nums).boxed().collect(Collectors.toSet());

        if (set.size() > 0) {
            int longest = 0;

            for (Integer number: set) {
                int length = 0;
                if (!set.contains(number - 1)) {
                    length = 1;
                    while (set.contains(number + 1)) {
                        length++;
                        number = number + 1;
                    }
                }
                longest = Math.max(length, longest);
            }
            return longest;
        }
        return 0;
    }
}
