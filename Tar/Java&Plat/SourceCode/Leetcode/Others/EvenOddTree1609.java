
import java.util.*;

class TreeNode
{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val)
    {
        this.val = val;
    }
    TreeNode(int val, TreeNode left, TreeNode right)
    {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}


class Solution extends TreeNode
{
    public boolean isEvenOddTree(TreeNode root)
    {
        if(root == null)
            return false;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        int level = 0;
        int previous = 0;
        while(!queue.isEmpty())
        {
            int queue_size = queue.size();
            for (int i = 0; i < queue_size; i++)
            {
                TreeNode current = queue.poll();
                if(level % 2 == 0 && (current.val % 2 == 0 || (i > 0 && current.val <= previous)))
                    return false;
                if(level % 2 != 0 && (current.val % 2 != 0 || (i > 0 && current.val > previous)))
                    return false;
                previous = current.val;
                if(current.left != null)
                    queue.add(current.left);
                if(current.right != null)
                    queue.add(current.right);
            }
            level ++;
        }
        return true;
    }
}
