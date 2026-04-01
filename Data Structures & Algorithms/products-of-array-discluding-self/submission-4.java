class Solution {
    public int[] productExceptSelf(int[] nums) {
        var prefixProducts = new int[nums.length];
        Arrays.fill(prefixProducts, 1);
        //var suffixProducts = new int[nums.length];
        var result = new int[nums.length];
        Arrays.fill(result, 1);

        for (int i = 1; i < nums.length; i++) {
            System.out.println("i = " + i);
            prefixProducts[i] = prefixProducts[i - 1] * nums[i - 1];
        }

        for (int i = nums.length - 2; i >= 0 ; i--) {
            System.out.println("i = " + i);
            result[i] = result[i + 1] * nums[i + 1];
        }

        for (int i = 0; i < nums.length; i++) {
            result[i] *= prefixProducts[i];
        }

        return result;
    }
}  
