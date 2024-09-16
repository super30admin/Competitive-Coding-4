#TC: O(n)
#SC: O(1)

class ListNode(object):
    def __init__(self, x):
        self.val = x
        self.next = None

class Solution(object):

    def __reverse(self, head):
        
        prevNode = None
        currNode = head
        nextNode = head.next

        while (nextNode != None):
            currNode.next = prevNode
            prevNode = currNode
            currNode = nextNode
            nextNode = nextNode.next

        currNode.next = prevNode
        return currNode

    def isPalindrome(self, head):
        
        if (head == None or head.next == None):
            return True

        slowNode = head
        fastNode = head.next

        while (fastNode != None and fastNode.next != None):
            slowNode = slowNode.next
            fastNode = fastNode.next.next

        fastNode = self.__reverse(slowNode.next)
        slowNode.next = None
        slowNode = head

        while (slowNode != None and fastNode != None):
            if (slowNode.val != fastNode.val):
                return False
            slowNode = slowNode.next
            fastNode = fastNode.next

        return True