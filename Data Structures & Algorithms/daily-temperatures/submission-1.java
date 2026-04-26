class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        /* Use a monotonic decreasing stack to keep track of what days still don't have a warmer future day */
        Stack<int[]> stack = new Stack<>();
        int[] result = new int[temperatures.length];

        for(int i = 0; i < temperatures.length; i++) {
            /* When a warmer day is found, pop the stack and add the number of elapsed days (meaning the index of the current temperature
            minus the index of the temperature popped from the stack) to the result array */
            while(!stack.isEmpty() && (stack.peek()[1] < temperatures[i])) {
                int[] top = stack.pop();
                result[top[0]] = i - top[0];
            }
            /* When a colder day is found, push it into the stack */
            int[] temp = {i, temperatures[i]};
            stack.push(temp);
        }

        return result;
    }
}
