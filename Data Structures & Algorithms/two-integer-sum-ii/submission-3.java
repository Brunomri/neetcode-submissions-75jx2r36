class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int[] indexes = new int[2];

        /*for (int i = 0; i < numbers.length; i++) {
            if (i == numbers.length - i)  {
                break;
            }
            int first = numbers[i];
            int second = numbers[numbers.length - (i + 1)];
            System.out.println("first = " + first);
            System.out.println("second = " + second);
            int result = first + second;
            if (result == target) {
                indexes[0] = i + 1;
                indexes[1] = numbers.length - i;
                return indexes;
            }
            if (result < target) {
                continue;
            } else {

            }
        }*/

        /*outerloop:
        for (int i = 0; i < numbers.length; i++) {
            for (int j = numbers.length - 1; j >= 0; j--) {
                if (i == j) break outerloop;
                int first = numbers[i];
                int second = numbers[j];
                int result = first + second;
                System.out.println(String.format("%d + %d = %d", first, second, result));
                if (result == target) {
                    indexes[0] = i + 1;
                    indexes[1] = j + 1;
                    System.out.println(String.format("result found: [%d, %d]", indexes[0], indexes[1]));
                    return indexes;
                }
                if (result < target) {
                    i++;
                } else {
                    j--;
                }
            }
        }*/

        int i = 0;
        int j = numbers.length - 1;
        while (j > i) {
            int first = numbers[i];
            int second = numbers[j];
            int result = first + second;
            System.out.println(String.format("%d + %d = %d", first, second, result));
            if (result == target) {
                indexes[0] = i + 1;
                indexes[1] = j + 1;
                System.out.println(String.format("result found: [%d, %d]", indexes[0], indexes[1]));
                return indexes;
            }
            if (result < target) {
                i++;
            } else {
                j--;
            }
        }

        return indexes;
    }
}
