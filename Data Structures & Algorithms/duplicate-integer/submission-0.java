class Solution {
    public boolean hasDuplicate(int[] nums) {
        var appeared = new ArrayList();

        for (int number: nums) {
            if (appeared.contains(number)) {
                return true;
            }
            appeared.add(number);
        }
        return false;
    }
}
