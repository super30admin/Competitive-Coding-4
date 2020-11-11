# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution(object):
    def isPalindrome(self, head):
        """
        :type head: ListNode
        :rtype: bool
        """

        # start1=start=ListNode()
        # head1=head
        # while head1:
        #     start.next=ListNode(head1.val)
        #     start=start.next
        #     head1=head1.next
        # print('start1',start1)
        # prev=None
        # curr=head
        # while curr:
        #     next_node=curr.next
        #     curr.next=prev
        #     prev=curr
        #     curr=next_node
        # print('start1',start1.next)
        # print('prev',prev)
        # return start1.next==prev

        if head == None:
            return True
        slow = head
        fast = head.next
        while fast != None and fast.next != None:
            slow = slow.next
            fast = fast.next.next
        head2 = slow.next
        # print(head2)
        slow.next = None
        slow = head
        prev = None
        curr = head2
        while curr != None:
            next_node = curr.next
            curr.next = prev
            prev = curr
            curr = next_node
        head2 = prev
        # print(head2)
        while head != None and head2 != None:
            if head.val != head2.val:
                return False
            else:
                head = head.next
                head2 = head2.next
        return True

    #time-o(n) space=o(1)