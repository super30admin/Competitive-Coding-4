# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
#Time Complexity:O(n)
#Space Complexity: O(1) extra space
class Solution:
    def isPalindrome(self, head: ListNode) -> bool:
        if not head or not head.next:
            return True

        #find the head of the second half part
        fast = head;
        slow = head;
        while fast and fast.next:
            fast = fast.next.next
            slow = slow.next
        
        #slow now is the head of second half

        #reverse the second half
        prev = None
        while slow:
            slow.next,slow,prev = prev,slow.next,slow
        #prev now is the head of reversed second half

        #compare the first part and the second part
        first = head
        second = prev
        while first and second:
            if first.val!=second.val:
                return False
            first, second = first.next, second.next
        return True
