#Time Complexity : O(n) where n is number of elements in list
#Space Complexity :  O(1)

#Did this code successfully run on Leetcode : Yes
#Three line explanation of solution in plain english: First find the first half of the array and reverse the second half of the linkedlist. Now comparing the first half and the second half of the linkedlist see if they are equal at each element, that is iterating simultaneously through both halves. If anywhere the values aren't equal return False. Else in the end we just return True. 

#Your code here along with comments explaining your approach

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def isPalindrome(self, head: ListNode) -> bool:
        if not head:
            return True
        slow, fast = head, head
        while fast.next and fast.next.next:
            slow = slow.next
            fast = fast.next.next

        prev, curr = None, slow.next
        slow.next = None
        while curr:
            temp = curr.next
            curr.next = prev
            prev = curr
            curr = temp

        f, l = head, prev
        while f and l:
            if f.val != l.val:
                return False
            f = f.next
            l = l.next

        return True
