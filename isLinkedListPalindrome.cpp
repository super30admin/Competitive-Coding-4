/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 */
class Solution {
public:
    // TC - O(n)
    // SC - O(1)
    bool isPalindrome(ListNode* head) {

        if(head== NULL  || head->next == NULL) return true;
        ListNode* midNode = getMidNode(head);
        reverseList(midNode);

        midNode = getMidNode(head);
        ListNode* startNode2 = midNode->next;
        ListNode* startNode = head;
        while(startNode2){
            if(startNode->val != startNode2->val) return false;
             startNode2 = startNode2->next;
             startNode = startNode->next;
        }
        reverseList(midNode);
        return true;

    }

    ListNode* getMidNode(ListNode* node){
        ListNode* slowPointer = node;
        ListNode* fastPointer = node;
        while(fastPointer ->next && fastPointer->next->next){
            slowPointer = slowPointer->next;
            fastPointer = fastPointer->next->next;
        }
        return slowPointer;
    }

    void reverseList(ListNode*& node){
        ListNode* prev = NULL;
         ListNode* node1 = node->next;
        while(node1){
         ListNode* temp = node1->next;
         node1->next = prev;
         prev = node1;
         node1=temp;
        }
        node->next = prev;
    }

};