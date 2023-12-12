//TC: O(n)
//SC:O(1)

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
    bool isPalindrome(ListNode* head) 
    {
        if(head == NULL ||head->next == NULL) return true;

        ListNode *slow = head;
        ListNode *fast = head;

         while(fast->next!= NULL && fast->next->next!= NULL )
        {
            slow = slow->next;
            fast = fast->next->next;
        }

        ListNode *head2 = slow->next;
        slow->next = NULL;

        head2 = reverse(head2);
       

        while(head2!= NULL && head!= NULL)
        {
            if(head->val != head2->val)
            {
                return false;
            }
            head = head->next;
            head2 = head2->next;
            
        }
        
        return true;
    }

    private:
    ListNode * reverse(ListNode * head2)
    {
        if(head2 == NULL || head2->next == NULL) return head2;
         ListNode*prev = NULL;
         ListNode* curr = head2;        
         ListNode* fast = head2->next;

         while(fast!= NULL)
         {
             curr->next = prev;
             prev = curr;
             curr=fast;
             fast = fast->next;
         }
         curr->next = prev;
        return curr;
    }
};