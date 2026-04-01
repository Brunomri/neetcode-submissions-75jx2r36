class Solution {
    public boolean isAnagram(String s, String t) {
        var charArrayS = s.toCharArray();
        Arrays.sort(charArrayS);
        var sortedS = new String(charArrayS);

        var charArrayT = t.toCharArray();
        Arrays.sort(charArrayT);
        var sortedT = new String(charArrayT);

        if (sortedS.equals(sortedT)) {
            return true;
        }
        return false;
    }
}
