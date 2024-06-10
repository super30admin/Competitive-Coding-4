# TC - O(N)
# SC - O(1)

# Approach -

# find the mid point of the linked list
# reverse the links of the second half of the linked list
# keep a head at the starting node of the linked list and one at the middle of the linked list
# keep traversing till either one becomes null
# if the elements are not equal, then break the loop, else keep traversing
# reverse the linked list at the end of the traversal , so as to not modify the data


# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def isPalindrome(self, head: Optional[ListNode]) -> bool:

        if not head:
            return False

        midPoint = self.getMidPoint(head)
        revHead = self.reverseList(midPoint)
        currHead = head
        finalResult = True

        while currHead is not None and revHead is not None:

            if currHead.val != revHead.val:
                finalResult = False
                break

            currHead = currHead.next
            revHead = revHead.next

        midPoint.next = self.reverseList(midPoint)
        return finalResult

    def reverseList(self, head):

        prevNode = None
        currNode = head
        nextNode = None

        while currNode != None:
            nextNode = currNode.next
            currNode.next = prevNode
            prevNode = currNode
            currNode = nextNode

        return prevNode

    def getMidPoint(self, head):

        a = head
        b = head

        while b.next != None and b.next.next != None:
            a = a.next
            b = b.next.next

        return a
