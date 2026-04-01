class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        // Firstly sort the array to enable moving the two pointers according to the sum value and the target
        Arrays.sort(nums);

        System.out.println(nums);
        // i is the pointer to the first number, iterate over the array following the natural order
        for (int i = 0; i < nums.length; i++) {

            // Skip duplicate first element
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int first = nums[i];
            // Since the sum of the 3 numbers must be zero, our target value for the
            // sum of the second and third is the the opposite value of the first number
            int target = -first;
            System.out.println("target " + target);

            // left is the pointer of the second number, starts as the number immediately to the right of i
            int left = i + 1;
            // right is the pointer of the third number, starts as the last number of the array
            int right = nums.length - 1;

            // Apply two pointer strategy to find the second and third numbers
            while (left < right) {
                
                int second = nums[left];
                int third = nums[right];
                int sum = second + third;
                System.out.println(String.format("%d + %d = %d", second, third, second + third));

                if (sum == target) {
                    List<Integer> triplet = new ArrayList();
                    triplet.add(first);
                    triplet.add(second);
                    triplet.add(third);
                    result.add(triplet);
                    System.out.println("added triplet " + triplet);

                    while (left < right && nums[left] == nums[left + 1]) {
                        System.out.println("Jumping duplicate second number");
                        left++;
                    }

                    while (left < right && nums[right] == nums[right - 1]) {
                        System.out.println("Jumping duplicate third number");
                        right--;
                    }

                    left++;
                    right--;
                }

                else if (sum < target) {
                    left++;
                    while (left < right && nums[left] == nums[left - 1]) {
                        System.out.println("Jumping duplicate second number");
                        left++;
                    }
                }

                else {
                    right--;
                    while (left < right && nums[right] == nums[right + 1]) {
                        System.out.println("Jumping duplicate third number");
                        right--;
                    }
                }
            }
        }

        return result;
    }
}
