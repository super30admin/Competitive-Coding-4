# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
// Time Complexity : O(n) 
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
'''
1. Iterate over the linked list, save elements in stack
2. Iterate again now and compare value with popped value from stack
3. If they don't match, return False and exit
4. Return True

'''




class Solution:
    def isPalindrome(self, head: Optional[ListNode]) -> bool:
        
        L=[]
        
        start=head
        
        while start != None:
            L.append(start.val)
            start=start.next
            
        start=head
        while start != None:
            temp=L.pop()
            if start.val==temp:
                start = start.next
            else:
                return False
        return True
        