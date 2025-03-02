# Time Complexity : O(N)
# Space Complexity : O(N)
# Did this code successfully run on Leetcode : Yes      
# Any problem you faced while coding this : No  


# Your code here along with comments explaining your approach: Convert the linkedlist to an array. Use two pointers. One travelling from the first element with a step size of 1 and one starting on the final element and travelling backwards with a step size of 1. We traverse until they meet at the midpoint. If the element at the two pointers is not same we return false. 

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def isPalindrome(self, head: Optional[ListNode]) -> bool:
        arr = []
        while head is not None:
            arr.append(head.val)
            head = head.next
        
        n = len(arr)
        left = 0 
        right = n - 1

        while left <= right:
            if arr[left] != arr[right]:
                return False
            
            left += 1
            right -= 1
        
        return True
    