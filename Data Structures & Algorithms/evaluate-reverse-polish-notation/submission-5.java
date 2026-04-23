class Solution {

    public static final List<Character> operations = List.of('+', '-', '*', '/');

    public int evalRPN(String[] tokens) {
        Stack<Integer> operands = new Stack<>();

        if(tokens.length == 1) return Integer.valueOf(tokens[0]);

        for(int i = 0; i < tokens.length; i++) {
            if(tokens[i].equals("+") || tokens[i].equals("-") || tokens[i].equals("*") || tokens[i].equals("/")) {
                int op1 = operands.pop();
                int op2 = operands.pop();
                operands.push(calculate(op1, op2, tokens[i]));
            } else {
                operands.push(Integer.valueOf(tokens[i]));
            }
            System.out.println(operands.peek());
        }
        return operands.pop();
    }

    private int calculate(int op1, int op2, String operation) {
        switch(operation) {
            case "+":
                return op1 + op2;
            case "-":
                return op2 - op1;
            case "*":
                return op1 * op2;
            case "/":
                if (op1 == 0) return 0;
                return op2 / op1;
        }
        return 0;
    }
}
