# Number of Wonderful Substrings

'''
A wonderful string is a string where at most one letter appears an odd number of times.

    For example, "ccjjc" and "abab" are wonderful, but "ab" is not.

Given a string word that consists of the first ten lowercase English letters ('a' through 'j'),
return the number of wonderful non-empty substrings in word. 
If the same substring appears multiple times in word, then count each occurrence separately.

A substring is a contiguous sequence of characters in a string.

Example 1:

Input: word = "aba"
Output: 4
Explanation: The four wonderful substrings are underlined below:
- "aba" -> "a"
- "aba" -> "b"
- "aba" -> "a"
- "aba" -> "aba"

Example 2:

Input: word = "aabb"
Output: 9
Explanation: The nine wonderful substrings are underlined below:
- "aabb" -> "a"
- "aabb" -> "aa"
- "aabb" -> "aab"
- "aabb" -> "aabb"
- "aabb" -> "a"
- "aabb" -> "abb"
- "aabb" -> "b"
- "aabb" -> "bb"
- "aabb" -> "b"

Example 3:

Input: word = "he"
Output: 2
Explanation: The two wonderful substrings are underlined below:
- "he" -> "h"
- "he" -> "e"

Constraints:

    1 <= word.length <= 10^5
    word consists of lowercase English letters from 'a' to 'j'.
'''

'''
    Question requires working with parity
    
    A parity of the occurrence of some letters
    
    Constraints are important to notice here:
    
        we have only letters from 'a' till 'j' -> only 10 letters
        
    Brute force won't work because just to find out all the substrings we need O(n^2) complexity
    
    -------
    
    For these kind of problems we can use a DP
        For this the tricky part is how can we efficiently check at the current index, 
            what are the wonderful strings so far
            
        For this problem we can use DP with a bit mask
            the reason being, suppose we have a substring as: 
                xxxxxxxxxx
            
            we have 10 bit masks
                suppose our bit mask is: 1010101010
                
            * The way we're maintaining this mask is that, whenever we see any value 
                either 0 or 1, we simply revert them
                
                That basically means that each of the bit value represent the parity for a 
                    particular letter
                
            So our setting for the string and bit mask is as follows:
                j i h g f e d c b a
                1 0 1 0 1 0 1 0 1 0
                
            so for a=0 for example, it means that at that particular index we've even number of a's
            and for b=1 for example, it means that at that location we've odd number of b's
            
             Please note that, at each index we have a full bit mask.
                Why do we need to maintain that, because
                
                    Assuming at two indices we have the same bit mask, that basically means that:
                        for the substring in between the appearance of all the letters must be even
                        
                        because parity is same: (Odd - Odd = Even)
                                              * for info (Even - Even = Even)
                            
                    This covers one scenario that, we have found all the substrings that has 0 odd appearance
                    (In other words, for all the characters, count of a particular character in the string is even)
         
            -------
             
             For the scenario of at-most 1:
                
                Thinking more deeply about the bit masks, how to find the case when for all the characters, the
                    count of each character in the string is at most 1
                    
                    we can simply try to revert each of the bit value
                        for example suppose our substring and bit mask is:
                            h g f e d c b a
                            1 0 1 0 0 1 0 0
                        here if we revert the bit value for 'a' from 0 to 1 and we keep everything else as same
                            the mask will look like: 1 0 1 0 0 1 0 1
                        
                        and if we find the same substring some-where earlier also, that means that
                            the substring has 'a' appears odd number of times
                            because all the other letters in the string are same
                            
                            Basically:
                                Odd - Even = Odd
                                Even - Odd = Odd
                                
            -------
            
            To store the appearances of each of the bit mask we'll use a dictionary
                Taking an example for the even case:
                    suppose our sub-string and mask is as follows: 
                        j i h g f e d c b a
                        1 0 1 0 1 0 1 0 1 0
                        
                suppose at index=0, bitMask1 appears for the first time
                then at index=2, same bitmask appears again
                and finally at index=8, same bitmask appears for the third time
                
                    so, in total if we have three appearances of the same bitMask, so how many substrings
                        ending with the character at index=8 are wonderful strings
                            ans = 2 (because we have two same masks before)
                
                Therefore we need a counter to store the appearance of each of the masks   
'''

'''

suppose our string is: temp = "hhh"
    we will start from character to character

initially we have at temp[0] = 'h' and mask = 0

we'll also maintain a count array to store the count value for each of the mask
    initially our count array is : count[0] = 1

    S1: we will create the index value for this character
            index = ord(temp[0]) - ord('a')
        let our index = 7
    
    S2: we'll left shift our index value (more precisely 1 << index) or index = pow(2, index)
        let now our index becomes 128

    S3: we'll create a mask out of this
        more precisely mask = mask ^ (pow(2, index))
        let our mask = 128 (as initially mask was 0)
        so 0^128 = 128

    S4: we'll increment our ans by the value stored at the count array
        more precisely: ans += count[mask]

        since at this point each new value of the mask will have the 0 stored in the count array, therefore
            in this case ans remains 0

        * Suppose next time we again see the same character 'h', our old value of the mask was 128
            and (1 << index) will also produce 128

            hence, 128^128 = 0 (that means we are now seing this character 2nd time which is even)

            in this case we have to increase our count
                also count[0] = 1 (hence ans is increased)

'''

from collections import defaultdict

class Solution:
    def wonderfulSubstrings(self, word: str) -> int:
        mask = 0
        count = defaultdict(int)
        ans = 0
        # We have to handle the base cases, for example when there is just one letter e.g. 'a'
        # Later in the implementation we'll be reverting the bit value, so for a it will become 0 and
        # the ans will be 0, but it should be 1
        count[0] = 1
        for c in word:
            print("char is: ", c)
            index = ord(c) - ord('a')  # can be used to do bit manipulation
            print("index is: ", index)
            print("1 << index: ", 1 << index)
            # every time we see numbers here we will find its corresponding index
            # and basically we'll use the mask to revert the bit value (either from 0 to 1 or 1 to 0)
            mask ^= (1 << index)
            print("mask is: ", mask)
            ans += count[mask]
            print()
            print("counter: ", count)
            print()
            print("ans: ", ans)
            print()
            # Case: Odd-Even (one letter appears odd number of times)
            # for this we have to check each number
            # As we've 10 letters in total
            for i in range(10):
                # We need to flip the values of each bit
                preMask = mask ^ (1 << i)
                print("PreMask: ", preMask)
                ans += count[preMask]
                print("counter next: ", count)
                print()
            count[mask] += 1
            print("counter final: ", count)
            print()
            print("-------")
        print("ans is: ", ans)
        return ans

testInstance = Solution()
testInstance.wonderfulSubstrings("hhhh")