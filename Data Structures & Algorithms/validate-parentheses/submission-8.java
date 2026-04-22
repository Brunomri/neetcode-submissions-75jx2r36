class Solution {

    public Map<Character, Character> matching = Map.of('(', ')', '{', '}', '[', ']');

    public boolean isValid(String s) {
        Stack<Character> opened = new Stack<>();
        Set<Character> openers = matching.keySet();
        Set<Character> closers = new HashSet<>(matching.values());
        
        for(char c: s.toCharArray()) {
            if(openers.contains(c)) opened.push(c);
            if(opened.isEmpty() && closers.contains(c)) return false;
            if(closers.contains(c) && !check(opened.pop(), c)) return false;
        }

        return opened.isEmpty();
    }

    private boolean check(Character open, Character close) {
        Character expected = matching.get(open);
        return close.equals(expected);
    }
}
