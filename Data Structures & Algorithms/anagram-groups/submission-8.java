class Solution {
    public static final int NUM = 31;

    /* Time complexity of this algorithm is O(m + n), where
    m is number of words, and n the size of longest word, because it iterates
    over every word and every character of each word. Space complexity is O(m)
    because in worst case, the hash map contains one entry for each word. */
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        /* Create a map where the key is a list of the frequency that each character
        appears in the list of words in associated value */
        var wordToFrequencies = new HashMap<List<Integer>, List<String>>();

        for (String word: strs) {
            /* For each word, create an array to store the frequency each 
            alphabet caracter appears */
            var frequencies = new int[26];
            for (char c: word.toCharArray()) {
                /* Find the position of the caracter in the frequencies array
                and increment it */
                int position = (c & NUM) - 1;
                frequencies[position]++;
            }

            var frequenciesList = Arrays.stream(frequencies).boxed().collect(Collectors.toList());
            List<String> words;
            /* If that frequency already happened before, the current
                word is an anagram of another word processed before */
            if (wordToFrequencies.keySet().contains(frequenciesList)) {
                words = wordToFrequencies.get(frequenciesList);
                words.add(word);
            } else {
                /* If the frequency is not present in map, add it as a key
                and associate the current word to it */
                words = new ArrayList<String>();
                words.add(word);
            }
            wordToFrequencies.put(frequenciesList, words);
        }

        System.out.println("wordToFrequencies = " + wordToFrequencies.toString());
        /* The value of each entry in the map is a 
        group of anagrams, add them to the result list */
        wordToFrequencies.forEach((key, value) -> result.add(value));

        return result;
    }
}
