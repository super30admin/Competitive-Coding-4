# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
"""
TC = O(N) - WE WILL TRAVERSE THROUGH ALL THE ELEMENTS 
SC = O(N) - TO STORE ALL THE ELEMENTS
"""
class Solution:
    def isPalindrome(self, head: Optional[ListNode]) -> bool:
        vals =[]
        curr =head
        while curr is not None:
            vals.append(curr.val)
            curr = curr.next
        start = 0
        end = len(vals)
        while start<=end:
            if vals[start]!=vals[end]:
                return False
            start+=1
            end-=1
        
        return True