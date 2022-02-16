# Given a 32-bit signed integer, reverse digits of an integer.
# Example 1:
#
# Input: 123
# Output: 321
#
# Example 2:
#
# Input: -123
# Output: -321
#
# Example 3:
#
# Input: 120
# Output: 21


class Solution:
    def reverse(self, x: int) -> int:
        if x < 0:
            listString = []
            intToString = str(abs(x))
            for characters in reversed(range(len(intToString))):
                listString.append(intToString[characters])
            newString = ''.join(listString)
            newNumber = int(newString) * -1
            if newNumber > pow(2, 31) - 1 or newNumber < -pow(2, 31):
                return 0
            return newNumber

        else:
            listString = []
            intToString = str(x)
            for characters in reversed(range(len(intToString))):
                listString.append(intToString[characters])
            newString = ''.join(listString)
            newNumber = int(newString)
            if newNumber > pow(2, 31) - 1 or newNumber < -pow(2, 31):
                return 0


test_instance = Solution()
test_instance.reverse(120)
