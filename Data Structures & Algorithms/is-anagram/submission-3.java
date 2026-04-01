class Solution {
    public boolean isAnagram(String s, String t) {

        if (s.length() != t.length()) {
            return false;
        }

        var charCountS = new HashMap<Character, Integer>();
        var charCountT = new HashMap<Character, Integer>();

        for (int i = 0; i < s.length(); i++) {
            charCountS.put(s.charAt(i), charCountS.getOrDefault(s.charAt(i), 0) + 1);
            charCountT.put(t.charAt(i), charCountT.getOrDefault(t.charAt(i), 0) + 1);
        }

        return charCountS.equals(charCountT);
    }
}
