class Solution {

    public static final List<Character> operations = List.of('+', '-', '*', '/');

    public int evalRPN(String[] tokens) {
        Stack<Integer> operands = new Stack<>();

        if(tokens.length == 1) return Integer.valueOf(tokens[0]);

        for(int i = 0; i < tokens.length; i++) {
            if(tokens[i].equals("+") || tokens[i].equals("-") || tokens[i].equals("*") || tokens[i].equals("/")) {
                int op2 = operands.pop();
                int op1 = operands.pop();
                operands.push(calculate(op1, op2, tokens[i]));
            } else {
                operands.push(Integer.valueOf(tokens[i]));
            }
        }
        return operands.pop();
    }

    private int calculate(int op1, int op2, String operation) {
        switch(operation) {
            case "+":
                return op1 + op2;
            case "-":
                return op1 - op2;
            case "*":
                return op1 * op2;
            case "/":
                //if (op2 == 0) return 0;
                return op1 / op2;
        }
        return 0;
    }
}
