"""

A phrase is a palindrome if, after converting all uppercase letters into lowercase letters 
and removing all non-alphanumeric characters, it reads the same forward and backward. Alphanumeric 
characters include letters and numbers.

Given a string s, return true if it is a palindrome, or false otherwise.

"""

# Time Complexity : O(n)(technically 2 * O(n))
# Space Complexity : O(n). This can be optimized using 2 pointer approach
# Did this code successfully run on leetcode : Yes
# Any problem you faced while coding this : No

from typing import List

class Solution:
    def isPalindrome(self, s: str) -> bool:
        
        # creating new string removing all spaces and chcaracters - O(n)
        snew = ''.join(i for i in s if i.isalnum())

        # creating another string reverse of the new string - O(n)
        rev = ''.join(reversed(snew))

        # if lowercase of both strings are exactly the same, they are palindrome
        if snew.lower() == rev.lower():
            return True
        return False