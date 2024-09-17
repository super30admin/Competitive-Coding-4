# TC-O(n)
# SC-O(1)
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

class Solution:

    #first

    def isPalindrome(self, head: Optional[ListNode]) -> bool:

        if head.next == None:
            return True

        self.first = head

        return self.helper(head)


    def helper(self, head:ListNode) -> bool:
        #Base
        if(head == None):
            return True

        #Logic
        if self.helper(head.next) == False:
            return False

        if head.val != self.first.val:
            return False

        self.first = self.first.next

        return True