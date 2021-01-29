#Time Complexity:O(n)
#Space Complexity:O(n)

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def isPalindrome(self, head: ListNode) -> bool:
        if not head or not head.next:                   #if the Linked list has no node or just one node return true
            return True
        slow=fast=head                                  #assign slow and fast pointer to the head of the linked list
        while fast.next and fast.next.next:             #while fast is not at the last two nodes
            slow=slow.next                              # move slow pointer by one
            fast=fast.next.next                         #move fast pointer by two
        half=slow.next                                  #assign the linked list from middle onwards to new Linked list
        slow.next=None                                  #mask the slow pointer node point to null
        half=self.rev(half)                             #reverse the second half of the linked list
        fast=half                                       #assign fast pointer to the head of reveresed linked list
        slow=head                                       #assign slow pointer to the head of first half of linked list
        while fast:                                     #until the end of second half of linked list is not reached
            if fast.val==slow.val:                      #check if each element matches or not and move by one
                fast=fast.next                          #if matched move else return false
                slow=slow.next
            else:
                return False
        return True                                     #once the parsing is complete return true
    
    def rev(self,head:ListNode)->ListNode:              #reverse the linked list
        if not head or not head.next:                   #if the node is empty or has only one node return 
            return head
        rev=self.rev(head.next)                         #recursive call that goes until the last node of linked list
        head.next.next=head                             #assign current node to 2nd position from now
        head.next=None                                  #assign its next to null/dectach from linked list
        return rev                                      #return reversed linked list.
        