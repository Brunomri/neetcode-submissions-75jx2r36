class Solution {
    /* This algorithm is O(n) because the while loop only runs if the number is a start of sequence. Each element is either the start of a sequence or part of a sequence that starts somewhere else.
    Therefore, each sequence is processed only once, all numbers inside a sequence are visited only as part of a single walk-through. */
    public int longestConsecutive(int[] nums) {
        /* Create a set from the list to enable O(1) lookup */
        var set = Arrays.stream(nums).boxed().collect(Collectors.toSet());

        if (set.size() > 0) {
            int longest = 0;

            for (Integer number: set) {
                int length = 0;
                /* If previous number is absent from the set, the current number is the start of a sequence */
                if (!set.contains(number - 1)) {
                    /* At the beginning, the sequence has length 1 because it contains only the starting number */
                    length = 1;
                    /* If the sequence contains the next number, increase the sequence length and update the current number
                    to keep looking for the next number until it is absent from the sequence */
                    while (set.contains(number + 1)) {
                        length++;
                        number = number + 1;
                    }
                }
                /* Keep track of the longest sequence */
                longest = Math.max(length, longest);
            }
            return longest;
        }
        return 0;
    }
}
