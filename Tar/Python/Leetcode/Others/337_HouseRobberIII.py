'''
The thief has found himself a new place for his thievery again.
There is only one entrance to this area, called the "root."
Besides the root, each house has one and only one parent house.

After a tour, the smart thief realized that "all houses in this place forms a binary tree".
It will automatically contact the police if two directly-linked houses were broken into
on the same night.

Determine the maximum amount of money the thief can rob tonight without alerting the police.
'''


# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    def rob(self, root: TreeNode) -> int:
        cacheCanRobHouse = {}
        cacheCannotRobHouse = {}

        def maxMoneyCanRobHouse(node):
            if node is None:
                return 0
            if node in cacheCanRobHouse:
                return cacheCanRobHouse[node]

            moneyRobbingHouse = node.val + \
                maxMoneyCannotRobHouse(node.left) + \
                maxMoneyCannotRobHouse(node.right)
            moneyNotRobbingHouse = 0 + \
                maxMoneyCanRobHouse(node.left) + \
                maxMoneyCanRobHouse(node.right)
            cacheCanRobHouse[node] = max(
                moneyRobbingHouse, moneyNotRobbingHouse)

            return cacheCanRobHouse[node]

        def maxMoneyCannotRobHouse(node):
            if node is None:
                return 0

            if node in cacheCannotRobHouse:
                return cacheCannotRobHouse[node]

            moneyNotRobbingHouse = 0 + \
                maxMoneyCanRobHouse(node.left) + \
                maxMoneyCanRobHouse(node.right)
            cacheCannotRobHouse[node] = moneyNotRobbingHouse

            return cacheCannotRobHouse[node]

        return maxMoneyCanRobHouse(root)
