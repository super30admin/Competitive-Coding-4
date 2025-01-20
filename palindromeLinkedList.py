# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    # TC : O(n)
    # SC : O(1)
    def isPalindrome(self, head: Optional[ListNode]) -> bool:
        def reverseList(node):
            # TC for reversing: O(n)
            if node is None or node.next is None:
                return node
            rev = reverseList(node.next)
            node.next.next = node
            node.next = None
            return rev
        if head is None:
            return False
        # find middle node of list
        slow,fast = head,head
        while fast and fast.next:
            slow = slow.next
            fast = fast.next.next
        # reverse the second half of list
        revp = reverseList(slow)
        # compare the reversed list and first half of original list
        temp = head
        while revp is not None:
            if revp.val != temp.val:
                return False
            revp = revp.next
            temp = temp.next
        return True
        