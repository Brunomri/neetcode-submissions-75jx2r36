class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        /* Use a monotonic decreasing stack to keep track of what days still don't have a warmer future day */
        Stack<Integer> stack = new Stack<>();
        /* We can use a stack where only the indexes are stores, and use them to get the values from temperatures array */
        int[] result = new int[temperatures.length];

        for(int i = 0; i < temperatures.length; i++) {
            /* When a warmer day is found, pop the stack and add the number of elapsed days (meaning the index of the current temperature
            minus the index of the temperature popped from the stack) to the result array */
            while(!stack.isEmpty() && (temperatures[stack.peek()] < temperatures[i])) {
                int top = stack.pop();
                result[top] = i - top;
            }
            /* When a colder day is found, push it into the stack */
            stack.push(i);
        }

        return result;
    }
}
