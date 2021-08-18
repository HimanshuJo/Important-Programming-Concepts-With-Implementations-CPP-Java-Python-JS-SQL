
/*

The lowest common ancestor (LCA) is defined between two nodes p and q as the lowest node in T
    that has both p and q as descendants (we allow a node to be descendant of itself)

Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
Output: 3
Explanation: The LCA of nodes 5 and 1 is 3.

*/

/*

We can use recursion in this problem

Base Case:

    if root == null or
    root.val == p.val or
    root.val == q.val

        return root

Recursive Case:

    we need to get the TreeNode at left and TreeNode at right

        TreeNode left = lowestCommonAncestor(TreeNode left, TreeNode p, TreeNode q)
        TreeNode right = lowestCommonAncestor(TreeNode right, TreeNode p, TreeNode q)

        check if left and right are not null
            return root
        else return the node which is not null

Time Complexity:

    O(n)  where n is the number of nodes in the tree

        as the worst case is similar to traversing a linked list


*/


class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root.val == p.val || root.val == q.val) {
            return root;
        } else {
            TreeNode left = lowestCommonAncestor(root.left, p, q);
            TreeNode right = lowestCommonAncestor(root.right, p, q);
            if (left != null && right != null) {
                return root;
            } else {
                return left != null ? left: right;
            }
        }
    }
}
