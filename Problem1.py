#Time complexity is: O(n)
#Space complexity is: O(1)
#COde ran successfully on leetcode
#No problem faced while coding this program

#Palindrome linkedlist
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
        if(head==None or head.next==None):
            return True
        #Taking slow and fast pointers to find mid point in given linkned list
        self.slow=head
        self.fast=head

        while(self.fast.next!=None and self.fast.next.next!=None):
            self.slow=self.slow.next
            self.fast=self.fast.next.next
        #find the reverse array from slow.next position
        self.head2=self.slow.next
        self.slow.next=None
        self.head2=self.reverse(self.head2)
        #Comparing the given linked list(divided after finding mid) and the reversed linked list
        # If there is any mismatch in the linked list value, we will return false 
        while(head!=None and self.head2!=None):
            if(head.val!=self.head2.val):
                return False
            head=head.next
            self.head2=self.head2.next
        return True

    #method to reverse the linked list
    def reverse(self,root):
        self.prev=None
        self.curr=root
        self.fast=root.next

        while(self.fast):
            self.curr.next=self.prev
            self.prev=self.curr
            self.curr=self.fast
            self.fast=self.fast.next
            
        self.curr.next=self.prev
        return self.curr
        



