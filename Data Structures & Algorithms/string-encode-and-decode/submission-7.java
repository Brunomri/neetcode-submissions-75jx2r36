class Solution {

    public String encode(List<String> strs) {
        var sb = new StringBuilder();
        for (String s: strs) {
            var length = s.length();
            sb.append(length);
            sb.append("#");
            sb.append(s);
        }
        System.out.println("encode = " + sb.toString());
        return sb.toString();
    }

    public List<String> decode(String str) {
        var result = new ArrayList<String>();
        
        while (str.length() > 0) {
            String length = String.valueOf(str.split("#")[0]);
            System.out.println("length = " + Integer.parseInt(length));
            int lengthSize = String.valueOf(length).length();
            System.out.println("lengthSize = " + lengthSize);
            var word = str.substring(lengthSize + 1, lengthSize + 1 + Integer.parseInt(length));
            str = str.substring(lengthSize + 1 + Integer.parseInt(length));
            System.out.println("word = " + word);
            System.out.println("str = " + str);
            result.add(word);
        }
        return result;
    }
}
