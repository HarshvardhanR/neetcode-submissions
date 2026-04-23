class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> rpnStack = new Stack<>();
        
        for (String token : tokens) {
            if (!token.equals("+") && !token.equals("*") && !token.equals("-") && !token.equals("/")) {
                rpnStack.push(Integer.parseInt(token));
            } else {
                int secondElement = rpnStack.pop();
                int firstElement = rpnStack.pop();
                
                if (token.equals("+")) {
                    rpnStack.push(firstElement + secondElement);
                } else if (token.equals("*")) {
                    rpnStack.push(firstElement * secondElement);
                } else if (token.equals("-")) {
                    rpnStack.push(firstElement - secondElement);
                } else if (token.equals("/")) {
                    rpnStack.push(firstElement / secondElement);
                }
            }
        }
        
        return rpnStack.pop();
    }
}
