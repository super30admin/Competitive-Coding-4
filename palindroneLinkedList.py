#TimeComplexity:O(N) 
#SpaceComplexity: O(1)
#Did this code successfully run on Leetcode : Yes 
#Any problem you faced while coding this : No
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def isPalindrome(self, head: ListNode) -> bool:
        end=head
        mid=head
        while(end and end.next):
            mid=mid.next
            end=end.next.next
        prev=None
        end=mid
        while(end):
            end=mid.next
            mid.next=prev
            prev=mid
            mid=end
        while(prev):
            if prev.val==head.val:
                prev=prev.next
                head=head.next
            else:
                return False
        return True
            
        