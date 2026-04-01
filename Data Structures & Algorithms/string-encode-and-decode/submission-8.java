class Solution {

    /* The encoding strategy is to add a prefix to each string
    with the length of the string and a '#' to split the length and
    the original content */
    public String encode(List<String> strs) {
        var sb = new StringBuilder();
        for (String s: strs) {
            var length = s.length();
            sb.append(length);
            sb.append("#");
            sb.append(s);
        }
        System.out.println("encode = " + sb.toString());
        /* The string builder will contain all the new strings with
        their prefixes concatenated */
        return sb.toString();
    }

    public List<String> decode(String str) {
        var result = new ArrayList<String>();
        
        /* To decode the string, we use the length prefix built during
        the encoding to extract each word and update the remaining string to be
        processed on the next iteration until its empty */
        while (str.length() > 0) {
            /* Firstly we extract from the string the length of the current
            word and how many digits it has */
            String length = String.valueOf(str.split("#")[0]);
            System.out.println("length = " + Integer.parseInt(length));
            int lengthSize = String.valueOf(length).length();
            System.out.println("lengthSize = " + lengthSize);
            /* Then we use ignore the prefix and the '#' to retrieve the actual word */
            var word = str.substring(lengthSize + 1, lengthSize + 1 + Integer.parseInt(length));
            /* Finally we update the remaining string by removing the prefix, the '#'
            character and the word we just extracted */
            str = str.substring(lengthSize + 1 + Integer.parseInt(length));
            System.out.println("word = " + word);
            System.out.println("str = " + str);
            result.add(word);
        }
        return result;
    }
}
