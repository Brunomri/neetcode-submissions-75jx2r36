class PrefixTree {

    Map<Character, PrefixTree> children;
    boolean validWord;

    public PrefixTree() {
        children = new HashMap<>();
        validWord = false;
    }

    public void insert(String word) {
        char[] characters = word.toCharArray();

        PrefixTree node = this;
        for(char character: characters) {
            /* Check if the current character is already a prefix */
            PrefixTree next = node.children.get(character);
            if(next == null) {
                /* In case not, create a new node for this character 
                and add it to the map of the current node */
                next = new PrefixTree();
                node.children.put(character, next);
            }
            /* Move to the next node before adding the next character */
            node = next;
        }
        /* After all the characters have been inserted, 
        set validWord of the last node to true */
        node.validWord = true;
    }

    public boolean search(String word) {
        char[] characters = word.toCharArray();

        PrefixTree node = this;
        for(char character: characters) {
            /* Check if the current character is already a prefix */
            PrefixTree next = node.children.get(character);
            /* If any character is missing from the tree, the word is not present */
            if(next == null) return false;
            /* Move to the next node before checking the next character */
            node = next;
        }
        /* In the end, if the last node has validWord set to true, the prodivded word
        was indeed inserted, otherwise it's a prefix for another word */
        return node.validWord;
    }

    public boolean startsWith(String prefix) {
        char[] characters = prefix.toCharArray();

        PrefixTree node = this;
        for(char character: characters) {
            /* Check if the current character is already a prefix */
            PrefixTree next = node.children.get(character);
            /* If any character is missing from the tree, the prefix is not present */
            if(next == null) return false;
            /* Move to the next node before checking the next character */
            node = next;
        }
        /* In the end, if all characters were found, the prefix is in the tree */
        return true;
    }
}
