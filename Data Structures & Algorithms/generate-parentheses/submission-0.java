class Solution {
    List<String> ans = new ArrayList<>();
    Stack<Character> stk = new Stack<>();
    
    public void backtrack(int open, int closed, int n) {
        if (open == closed && open == n) {
            StringBuilder current = new StringBuilder();
            for (char c : stk) {
                current.append(c);
            }
            ans.add(current.toString());
            return;
        }

        if (open < n) {
            stk.push('(');
            backtrack(open + 1, closed, n);
            stk.pop();
        }

        if (closed < open) {
            stk.push(')');
            backtrack(open, closed + 1, n);
            stk.pop();
        }
    }

    public List<String> generateParenthesis(int n) {
        backtrack(0, 0, n);
        return ans;
    }
}
