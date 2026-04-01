class Solution {
    public int lengthOfLongestSubstring(String s) {

        if (s == null || s.length() == 0) return 0;
        if (s.length() == 1) return 1;

        Set<Character> charSet = new HashSet<>();
        int leftIndex = 0;
        int rightIndex = 1;
        charSet.add(s.charAt(leftIndex));
        int longest = 1;

        while (leftIndex < s.length() && rightIndex < s.length()) {
            //var leftChar = s.charAt(leftIndex);
            //var rightChar = s.charAt(rightIndex);

            if (charSet.add(s.charAt(rightIndex))) {
                System.out.println("added " + s.charAt(rightIndex));
                var windowSize = rightIndex - leftIndex + 1;
                if (windowSize > longest) {
                    longest = windowSize;
                }
                rightIndex++;
            } else {
                charSet.clear();
                System.out.println("cleared");
                leftIndex++;
                charSet.add(s.charAt(leftIndex));
                System.out.println("added " + s.charAt(leftIndex));
                rightIndex = leftIndex + 1;
            }
        }
        return longest;
    }
}
