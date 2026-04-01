class Solution {
    public boolean isPalindrome(String s) {
        var lowercase = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        while (lowercase.length() > 2) {
            System.out.println("lowercase = " + lowercase);
            var first = lowercase.charAt(0);
            var last = lowercase.charAt(lowercase.length() - 1);
            System.out.println("first = " + first);
            System.out.println("last = " + last);
            if (first != last) {
                return false;
            }
            lowercase = lowercase.substring(1, lowercase.length() - 1);
        }
        System.out.println("lowercase = " + lowercase);
        return lowercase.trim().isEmpty() || lowercase.charAt(0) == lowercase.charAt(lowercase.length() - 1);
    }
}
