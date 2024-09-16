#Time Complexity : O(n)
#Space Complexity : O(1) 
# Did this code successfully run on Leetcode : Yes
#Any problem you faced while coding this : No

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def isPalindrome(self, head: Optional[ListNode]) -> bool:
    
        count = 1
        curr = head
        while curr.next != None:
            curr = curr.next
            count += 1

        head_1 = head
        head_2 = head

        if count%2 == 0:
            n = count/2
        else:
            n = count/2 +1

        count = 1
        while count<=n:
            head_2 = head_2.next
            count +=1

        prev = None
        curr = head_2
        next = head_2
        while curr != None:
            next = curr.next
            curr.next = prev
            prev = curr
            curr = next
        head_2 = prev

        while head_2 != None:
            if head_2.val != head_1.val:
                return False
            head_2 = head_2.next
            head_1 = head_1.next
        return True