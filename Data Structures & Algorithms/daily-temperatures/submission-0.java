class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<int[]> stack = new Stack<>();
        int[] result = new int[temperatures.length];

        for(int i = 0; i < temperatures.length; i++) {
            //System.out.println("i = " + i);
            //System.out.println("temp = %s".formatted(temperatures[i]));
            while(!stack.isEmpty() && (stack.peek()[1] < temperatures[i])) {
                int[] top = stack.pop();
                //System.out.println("pop top: i = %s, temp = %s".formatted(top[0], top[1]));
                result[top[0]] = i - top[0];
                //System.out.println("added to result[%s]: %s".formatted(top[0], i - top[0]));
            }
            int[] temp = {i, temperatures[i]};
            stack.push(temp);
            //System.out.println("push temp: i = %s, temp = %s".formatted(temp[0], temp[1]));
        }

        return result;
    }
}
