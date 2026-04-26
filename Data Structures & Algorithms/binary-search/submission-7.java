class Solution {
    public int search(int[] nums, int target) {
        return bs(0, nums.length - 1, nums, target);
    }

    private int bs(int start, int end, int[] nums, int target) {
        if(start > end) return -1;

        int mid = start + (end - start) / 2;
        
        if(nums[mid] == target) return mid;
        if(nums[mid] < target) return bs(mid + 1, end, nums, target);
        return bs(start, mid - 1, nums, target);
    }
}
