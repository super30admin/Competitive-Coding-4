# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def isPalindrome(self, head) :
        slow = head
        fast = head

        while fast is not None and fast.next is not None:          #finding middle of the list
            slow = slow.next
            fast = fast.next.next

        head2 = slow
        slow = None

        new = self.reve(head2)

        head1 = head
        head2 = new

        while head2 is not None:                    #comparing both list to check if its palindrome or not

            if head1.val == head2.val:
                head1 = head1.next
                head2 = head2.next
            else:
                return False
        return True

    def reve(self, head):         #reversing second half of the list

        prev = None
        curr = head
        fast = curr.next
        while fast is not None:
            curr.next = prev
            prev = curr
            curr = fast
            fast = fast.next
        curr.next = prev

        return curr



#Time Complexity : O(n)
#Space Complexity : O(n)





