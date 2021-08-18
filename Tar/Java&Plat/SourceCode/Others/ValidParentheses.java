
class Solution {

    public boolean isValid(String s) {

        boolean res = true;

        if (s.isEmpty()) {
            return res;
        }
        Stack<Character> stack = new Stack<>();

        char[] my_char = s.toCharArray();
        System.out.println(my_char);

        for (int i = 0; i < s.length(); i++) {

            switch (my_char[i]) {
                case ')':
                    try {
                    int current = stack.pop();
                    if (current != '(') {
                        res = false;
                    }
                } catch (Exception e) {
                    res = false;
                }
                break;
                case '}':
                    try {
                    int current = stack.pop();
                    if (current != '{') {
                        res = false;
                    }
                } catch (Exception e) {
                    res = false;
                }
                break;
                case ']':
                    try {
                    int current = stack.pop();
                    if (current != '[') {
                        res = false;
                    }
                } catch (Exception e) {
                    res = false;
                }
                break;
                default:
                    stack.push(my_char[i]);
                    break;
            }
        }
        if (stack.empty()) {
            return res;
        } else {
            res = false;
        }

        return res;
    }

    public static void main(String[] args) {
        Solution my_obj = new Solution();
        System.out.println(my_obj.isValid("()[]{}"));
    }
}
