# Time Complexity : O(N) where N is the number of nodes in the linked list
# Space Complexity : O(N) as we are using a list to store the values
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Your code here along with comments explaining your approach:
# We will traverse the linked list and store the values in a list.
# We will then check if the list is equal to its reverse.




from typing import Optional
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next
class Solution:
    def isPalindrome(self, head: Optional[ListNode]) -> bool:
        ans = []
        current = head
        while current:
            ans.append(current.val)
            current=current.next
        return ans == ans[::-1]



        