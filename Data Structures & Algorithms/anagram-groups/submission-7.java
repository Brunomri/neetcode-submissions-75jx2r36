class Solution {
    public static final int NUM = 31;

    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        var wordToFrequencies = new HashMap<List<Integer>, List<String>>();

        for (String word: strs) {
            var frequencies = new int[26];
            for (char c: word.toCharArray()) {
                int position = (c & NUM) - 1;
                frequencies[position]++;
            }

            var frequenciesList = Arrays.stream(frequencies).boxed().collect(Collectors.toList());
            List<String> words;
            if (wordToFrequencies.keySet().contains(frequenciesList)) {
                words = wordToFrequencies.get(frequenciesList);
                words.add(word);
            } else {
                words = new ArrayList<String>();
                words.add(word);
            }
            wordToFrequencies.put(frequenciesList, words);
        }

        System.out.println("wordToFrequencies = " + wordToFrequencies.toString());
        wordToFrequencies.forEach((key, value) -> result.add(value));

        return result;
    }
}
