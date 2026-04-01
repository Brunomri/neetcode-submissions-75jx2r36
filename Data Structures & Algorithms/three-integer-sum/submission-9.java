class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> result = new HashSet<>();
        Arrays.sort(nums);
        //List<Integer> numbers = Arrays.stream(nums).boxed().toList();

        System.out.println(nums);
        for (int i = 0; i < nums.length; i++) {
            int first = nums[i];
            int target = 0 - first;
            System.out.println("target " + target);

            int left = i+1;
            int right = nums.length - 1;

            while (left < right) {
                int second = nums[left];
                int third = nums[right];
                int sum = second + third;
                System.out.println(String.format("%d + %d = %d", second, third, second + third));

                if (sum == target) {
                    var triplet = new ArrayList();
                    triplet.add(first);
                    triplet.add(second);
                    triplet.add(third);
                    result.add(triplet);
                    System.out.println("added triplet " + triplet);
                    left++;
                    right--;
                }

                else if (sum < target) {
                    left++;
                }

                else {
                    right--;
                }
            }
        }
        
        /*int left = 0;
        int right = numbers.size() - 1;

        while (left < right) {
            int first = numbers.get(left);
            int second = numbers.get(right);
            int expectedThird = 0 - (first + second);

            List<Integer> sublist = numbers.subList(left + 1, right);
            for (Integer third: sublist) {
                if (third == expectedThird) {
                    var triplet = List.of(first, second, third);
                    result.add(triplet);
                    //break;
                }
            }

            left++;
            right--;
        }/*

        /*numbers.forEach(number -> {
            //System.out.println("here");
            int target = -number;
            System.out.println("target = " + target);
            var terms = new ArrayList<Integer>(numbers);
            terms.remove(number);

            int j = 0;
            int k = terms.size() - 1;

            while (j < k) {
                int second = terms.get(j);
                int third = terms.get(k);
                int sum = second + third;

                if (target == sum) {
                    var triplet = new ArrayList<Integer>();
                    triplet.add(number);
                    triplet.add(second);
                    triplet.add(third);
                    result.add(triplet);
                } else if (sum < target) {
                    j++;
                } else {
                    k--;
                }
            }
            terms.stream().forEach(System.out::println);
        });*/

        return new ArrayList(result);
    }
}
