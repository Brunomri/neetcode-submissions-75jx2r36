class Solution {
    /* In this solution we use a modified version of Bucket Sort. The traditional Bucket Sort array size is equal to the
    largest number of the input + 1, and the value of each index i is the frequency that value happened in the input. This approach
    would have time complexity O(n) only if the values in the input were bounded. 
    Besides, it is not clear where are the top k elements position in the array.
    Instead, we use an array with the size of the input, and the value of each 
    index i is a list of numbers that happended i times in the input. 
    Then the most frequent value is stored in the last position of this modified Bucket Sort array, and so on for the k most frequent values. */
    public int[] topKFrequent(int[] nums, int k) {
        var frequencies = new HashMap<Integer, Integer>();

        /* The frequencies hash map stores how many times each values happens in the input. */
        for (int num: nums) {
            frequencies.put(num, frequencies.getOrDefault(num, 0) + 1);
        }
        System.out.println("frequencies = " + frequencies.toString());

        /* The frequencyGroups is a list of arrays where is the index i means how many times the elements in that array happened in the input.
        Each group is initialized as an empty array. */
        List<Integer>[] frequencyGroups = new List[nums.length + 1];
        for (int i = 0; i < frequencyGroups.length; i++) {
            frequencyGroups[i] = new ArrayList<>();
        }

        /* Iterate over the entries of frequencies hash map, where the keys are the numbers from the input,
        and the values are how many times that number appeared. We use the values to find the index of frequencyGroups that
        correspond to that frequency, and we add that key to the list of that frequency. */
        for (Map.Entry<Integer, Integer> entry : frequencies.entrySet()) {
            frequencyGroups[entry.getValue()].add(entry.getKey());
        }

        System.out.print("frequencyGroups = ");
        for (int i = 0; i < frequencyGroups.length; i++) {
            System.out.print(frequencyGroups[i] + " ");
        }
        System.out.println();

        var result = new int [k];
        /* Index controls the position to add each element in the result array (or how many element were added) */
        int index = 0;
        /* Finally iterate over the frequencyGroups list of arrays map to build the result array.
        * Outer loop starts from the last index, which has the group of most frequent elements */
        for (int i = frequencyGroups.length - 1; i > 0 && index < k; i--) {
            System.out.println("group = " + frequencyGroups[i]);
            /* Inner loop iterates over each of elements that frequency group, if the array is empty
            * the loop just continues */
            for (int n: frequencyGroups[i]) {
                System.out.println("number = " + n);
                /* Add current number to the result array and increment index to account that an element
                was added to the result */
                result[index++] = n;
                if (index == k) {
                    /* If index == k this means that the k most frequent elements
                    * were already added to the result and it should be returned */
                    return result;
                }
                System.out.print("result = ");
                for (int j = 0; j < result.length; j++) {
                System.out.print(result[j] + " ");
                }
                System.out.println();
            }
        }
        return result;
    }
}
