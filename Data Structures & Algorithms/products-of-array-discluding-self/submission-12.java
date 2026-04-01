class Solution {
    /* This solution is optimized using the preffix and suffix approach
    to run in time complexity of O(n).
    Previous solutions used two intermediate arrays to store the products
    of the prefixes and suffixes, resulting in an O(n) space complexity.
    However, in this version we used a single result array to store
    directly the prefix and suffix values, resulting in O(1) space complexity. */
    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;

        var result = new int[len];
        /* Since there are no elements before index 0, the first prefix is 1. */
        result[0] = 1;

        /* Iterate over the numbers array from left to right to calculate the prefixes.
        Store them in the result array. */
        for (int i = 1; i < len; i++) {
            result[i] = result[i - 1] * nums[i - 1];
        }
        System.out.println("result = " + result);

        /* Since there are no elements after the last position in the numbers array,
        initialize the suffix with 1. */
        int suffix = 1;

        /* Iterate over the numbers array from right to left to calculate the suffixes.
        Store them in the result array. */
        for (int i = len - 1; i >= 0; i--) {
            /* The result array starts each pass with the prefix product for index i.
            Then we update the result for that index by multiplying the prefix by the suffix. */
            result[i] *= suffix;
            /* Update the suffix because the result of next iteration must
            include the number to the right */
            suffix *= nums[i];
        }

        return result;
    }
}  
