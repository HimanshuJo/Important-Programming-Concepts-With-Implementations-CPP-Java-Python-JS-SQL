import java.util.Stack;
class Solution
{
    public int minOperations(String[] logs)
    {
        Stack<String> stack = new Stack<String>();
        for (int i = 0; i < logs.length; i++)
        {
            logs[i] = logs[i].replaceAll("/", "");
            if (logs[i].equals("."))
                continue;
            else if (logs[i].equals(".."))
                try
                {
                    if(!stack.empty())
                        stack.pop();
                }
                catch (IndexOutOfBoundsException e)
                {
                    System.out.println("Out of bound");
                }
            else
                stack.push(logs[i]);

        }
        System.out.println(stack.size());
        return (stack.size());
    }

    public static void main(String[] args)
    {
        Solution new_obj = new Solution();
        String[] logs = {"d1/","../","../","../"};
        new_obj.minOperations(logs);
    }
}
