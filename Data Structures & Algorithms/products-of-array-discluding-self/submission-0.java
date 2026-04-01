class Solution {
    public int[] productExceptSelf(int[] nums) {
        var result = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            var operands = Arrays.stream(nums).boxed().collect(Collectors.toList());
            operands.remove(i);
            var product = operands.stream().reduce(1, (a, b) -> a * b);
            result[i] = product;
        }

        return result;
    }
}  
