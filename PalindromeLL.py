'''
Solution
1.  Find the mid of the LL using slow and fast pointers.
2.  Reverse the second part of the LL.
3.  Check each value in each half of the LL in parallel and return False if not equal, else return True

Time Complexity: O(n) and Space Complexity: O(1)

--- Passed all testcases on Leetcode successfully
'''


# Definition for singly-linked list.
class ListNode(object):
    def __init__(self, x):
        self.val = x
        self.next = None

class Solution(object):

    def __reverse(self, head):
        '''
        :param head: head of the Linked list
        :return: reversed Linked List
        '''
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
        """
        :type head: ListNode
        :rtype: bool
        """
        #   edge case check
        if (head == None or head.next == None):
            return True

        # initialize slow and fast pointers to find mid of the Linked List
        slowNode = head
        fastNode = head.next

        #   find the mid node iteratively
        while (fastNode != None and fastNode.next != None):
            slowNode = slowNode.next
            fastNode = fastNode.next.next

        #   reverse second half and initialize slow pointer to head again
        fastNode = self.__reverse(slowNode.next)
        slowNode.next = None
        slowNode = head

        #   check each value in each half of the LL in parallel
        while (slowNode != None and fastNode != None):
            if (slowNode.val != fastNode.val):
                return False
            slowNode = slowNode.next
            fastNode = fastNode.next

        return True