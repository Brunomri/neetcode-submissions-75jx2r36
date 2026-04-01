class Solution {
    public int[] productExceptSelf(int[] nums) {
        var prefixProducts = new int[nums.length];
        Arrays.fill(prefixProducts, 1);
        var suffixProducts = new int[nums.length];
        Arrays.fill(suffixProducts, 1);
        var result = new int[nums.length];

        for (int i = 1; i < nums.length; i++) {
            System.out.println("i = " + i);
            prefixProducts[i] = prefixProducts[i - 1] * nums[i - 1];
        }
        /*System.out.println("prefix = " + prefixProducts[0]);
        System.out.println("prefix = " + prefixProducts[1]);
        System.out.println("prefix = " + prefixProducts[2]);
        System.out.println("prefix = " + prefixProducts[3]);*/

        for (int i = nums.length - 2; i >= 0 ; i--) {
            System.out.println("i = " + i);
            suffixProducts[i] = suffixProducts[i + 1] * nums[i + 1];
        }
        /*System.out.println("suffix = " + suffixProducts[0]);
        System.out.println("suffix = " + suffixProducts[1]);
        System.out.println("suffix = " + suffixProducts[2]);
        System.out.println("suffix = " + suffixProducts[3]);*/

        for (int i = 0; i < nums.length; i++) {
            result[i] = prefixProducts[i] * suffixProducts[i];
        }

        return result;
    }
}  
