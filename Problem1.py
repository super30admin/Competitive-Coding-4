# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def isPalindrome(self, head: ListNode) -> bool:
        # Time complexity : O(n) where n is the number of nodes in the linked list
        # Space Complexity : constant because I'm not using any extra space
        if head == None:
            return True
        fast = head.next
        slow = head
        # Finiding the mid point in the list
        while fast != None and fast.next != None:
            fast = fast.next.next
            slow = slow.next
        head2 = slow.next # creating a new list for the second half after the mid-point in the list
        slow.next = None

        # reverse the second list(after the mid point)
        old = new = None
        cur = head2
        while cur != None:
            new = cur.next
            cur.next = old
            old = cur
            cur = new
        head2 = old

        # checking the value in each node in both the lists
        temp1 = head
        temp2 = head2
        while temp1 != None and temp2 != None:
            if temp1.val != temp2.val:
                return False
            temp1 = temp1.next
            temp2 = temp2.next
        return True