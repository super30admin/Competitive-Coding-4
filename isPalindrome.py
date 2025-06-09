# Time Complexity: O(n) = O(n) Find mid + O(n) Reverse the list + O(n) Compare the list
# Space Complexity: O(1)
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def isPalindrome(self, head: Optional[ListNode]) -> bool:
        if head == None:
            return True

        fast = head.next
        slow = head

        # Find mid point in the list
        while fast != None and fast.next != None:
            slow = slow.next
            fast = fast.next.next

        head2 = slow.next
        slow.next = None

        # Reverse the second half of the list
        old = new = None
        curr = head2
        while curr != None:
            new = curr.next
            curr.next = old
            old = curr
            curr = new
        head2 = old

        # Compare the values from both the head
        temp1 = head
        temp2 = head2
        while temp1 != None and temp2 != None:
            if temp1.val != temp2.val:
                return False
            temp1 = temp1.next
            temp2 = temp2.next
        return True