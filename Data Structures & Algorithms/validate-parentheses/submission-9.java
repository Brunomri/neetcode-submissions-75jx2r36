class Solution {
    /* Define a map of matching brackets */
    public Map<Character, Character> matching = Map.of('(', ')', '{', '}', '[', ']');

    public boolean isValid(String s) {
        /* Use a stack to track opened brackets */
        Stack<Character> opened = new Stack<>();
        /* Define sets of opening and closing brackets according to the matching map */
        Set<Character> openers = matching.keySet();
        Set<Character> closers = new HashSet<>(matching.values());
        
        /* Analyze the current character */
        for(char c: s.toCharArray()) {
            /* Opening brackets are always added to the stack */
            if(openers.contains(c)) opened.push(c);
            /* The expression is invalid if the stack is empty and a closing brackets comes in */
            if(opened.isEmpty() && closers.contains(c)) return false;
            /* The expression is invalid if a closing brackets comes in and it 
            doesn't match the last opened bracket */
            if(closers.contains(c) && !check(opened.pop(), c)) return false;
        }

        /* The expression is valid if the stack is empty in the end, 
        meaning that all opened brackets were closed */
        return opened.isEmpty();
    }

    /* Check the map to determine if opening and closing brackets are matching */
    private boolean check(Character open, Character close) {
        Character expected = matching.get(open);
        return close.equals(expected);
    }
}
