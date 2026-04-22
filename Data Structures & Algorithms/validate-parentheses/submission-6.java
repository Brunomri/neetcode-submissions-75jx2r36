class Solution {

    public Map<Character, Character> matching = Map.of('(', ')', '{', '}', '[', ']');

    public boolean isValid(String s) {
        Stack<Character> open = new Stack<>();
        Set<Character> openers = matching.keySet();
        Set<Character> closers = new HashSet<>(matching.values());
        
        if(s.length() < 2) return false;

        for(char c: s.toCharArray()) {
            if(openers.contains(c)) open.push(c);
            if(open.isEmpty() && closers.contains(c)) return false;
            if(closers.contains(c) && !check(open.pop(), c)) return false;
        }

        return open.isEmpty();
    }

    private boolean check(Character open, Character closed) {
        Character expected = matching.get(open);
        return closed.equals(expected);
    }
}
