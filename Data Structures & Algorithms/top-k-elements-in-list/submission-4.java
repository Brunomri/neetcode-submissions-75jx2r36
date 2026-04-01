class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        var frequencies = new HashMap<Integer, Integer>();

        for (int num: nums) {
            frequencies.put(num, frequencies.getOrDefault(num, 0) + 1);
        }
        System.out.println("frequencies = " + frequencies.toString());

        List<Integer>[] frequencyGroups = new List[nums.length + 1];
        for (int i = 0; i < frequencyGroups.length; i++) {
            frequencyGroups[i] = new ArrayList<>();
        }

        System.out.print("frequencyGroups = ");
        for (int i = 0; i < frequencyGroups.length; i++) {
            System.out.print(frequencyGroups[i] + " ");
        }
        System.out.println();

        System.out.println("key set = " + frequencies.keySet().toString());
        for (Map.Entry<Integer, Integer> entry : frequencies.entrySet()) {
            frequencyGroups[entry.getValue()].add(entry.getKey());
        }

        System.out.print("frequencyGroups = ");
        for (int i = 0; i < frequencyGroups.length; i++) {
            System.out.print(frequencyGroups[i] + " ");
        }
        System.out.println();

        var result = new int [k];
        int index = 0;
        for (int i = frequencyGroups.length - 1; i > 0 && index < k; i--) {
            System.out.println("group = " + frequencyGroups[i]);
            for (int n: frequencyGroups[i]) {
                System.out.println("number = " + n);
                result[index++] = n;
                if (index == k) {
                    return result;
                }
                System.out.print("result = ");
                for (int j = 0; j < result.length; j++) {
                System.out.print(result[j] + " ");
                }
                System.out.println();
            }
        }
        return result;
    }
}
