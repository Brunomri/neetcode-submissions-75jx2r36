class Solution {
    public int[] productExceptSelf(int[] nums) {
        //var prefixProducts = new int[nums.length];
        //Arrays.fill(prefixProducts, 1);
        int len = nums.length;

        var result = new int[len];
        result[0] = 1;

        for (int i = 1; i < len; i++) {
            result[i] = result[i - 1] * nums[i - 1];
        }
        System.out.println("result = " + result);

        int suffix = 1;
        for (int i = len - 1; i >= 0; i--) {
            result[i] *= suffix;
            suffix *= nums[i];
        }

        return result;
    }
}  
