class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int[] indexes = new int[2];

        int i = 0;
        int j = numbers.length - 1;
        /* Pointer i moves from left to right and point j moves from right to left,
        iteration stops when the indexes are the same */
        while (j > i) {
            int first = numbers[i];
            int second = numbers[j];
            int result = first + second;
            System.out.println(String.format("%d + %d = %d", first, second, result));
            if (result == target) {
                indexes[0] = i + 1;
                indexes[1] = j + 1;
                System.out.println(String.format("result found: [%d, %d]", indexes[0], indexes[1]));
                return indexes;
            }
            /* Since the array is order, if the result is too small we move the pointer i to the next number */
            if (result < target) {
                i++;
            /* If the result is too large, we move the pointer j to the previous number */
            } else {
                j--;
            }
        }

        return indexes;
    }
}
