# Merge BSTs to Create Single BST

'''
	You are given n BST (binary search tree) root nodes for n separate BSTs stored in an
	array trees (0-indexed). Each BST in trees has at most 3 nodes, and
	no two roots have the same value. In one operation, you can:

    Select two distinct indices i and j such that the value stored at one of the leaves of trees[i] is 
    equal to the root value of trees[j].
    Replace the leaf node in trees[i] with trees[j].
    Remove trees[j] from trees.

	Return the root of the resulting BST if it is possible to form a valid BST after
	performing n - 1 operations, or null if it is impossible to create a valid BST.

	A BST (binary search tree) is a binary tree where each node satisfies the following property:

	    Every node in the node's left subtree has a value strictly less than the node's value.
	    Every node in the node's right subtree has a value strictly greater than the node's value.

	A leaf is a node that has no children.

	Example:

		Input: trees = [[5,3,8],[3,2,6]]
		Output: []
		Explanation:
		Pick i=0 and j=1 and merge trees[1] into trees[0].
		Delete trees[1], so trees = [[5,3,8,2,6]].
'''


class Solution:
	def canMerge(self, trees: List[TreeNode]) -> TreeNode:
		leaves = set()
		# converting list to dict, to get O(1) time remove
		treeDict = {}
		for tree in trees:
			treeDict[tree.val] = tree
			if tree.left:
				leaves.add(tree.left.val)
			if tree.right:
				leaves.add(tree.right.val)
		root = None
		for tree in trees:
			if tree.val not in leaves:
				root = tree
				break
		if not root:
			return None
		# setting up candidate leaves to be merge with other BST
		curLeaves = {}
		# starting point for the current leaves
		if root.left:
			# in val -> lower range, higher range, parent node, left or right 
			curLeaves[root.left.val] = (-sys.maxsize, root.val, root, 0)
		if root.right:
			curLeaves[root.right.val] = (root.val, sys.maxsize, root, 1)
		del treeDict[root.val]
		while treeDict:
			# If the next tree to be merged can't be found return false
			findTree = False
			for leaf, (low, high, parent, leftOrRight) in curLeaves.items():
				if leaf in treeDict:
					newTree = treeDict[leaf]
					del curLeaves[leaf]
					# checking here if the new tree can be merged
					# we have to check both of the nodes within the range of
					# low and high
					if newTree.left:
						if low < newTree.left.val < high and newTree.left.val not in curLeaves:
							# once we merge here we have a new leaf node
							curLeaves[newTree.left.val] = (low, newTree.val, newTree, 0)
						else:
							return None
					if newTree.right:
						if low < newTree.right.val < high and newTree.right.val not in curLeaves:
							curLeaves[newTree.right.val] = (newTree.val, high, newTree, 1)
						else:
							return None
					# update parent node
					if leftOrRight == 0:
						parent.left = newTree
					else:
						parent.right = newTree
					findTree = True
					del treeDict[newTree.val]
					break
			if not findTree:
				return None
		return root
