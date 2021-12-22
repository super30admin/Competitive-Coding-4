//Time complexity : O(n)
//Space Complexity : O(1)


//Approach :
            // Reverse the second half of the linked list
            // Check each of the node from beginning to end

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
    bool isPalindrome(ListNode* head) {
        if(head == nullptr || head->next == nullptr)
            return true;
        
        ListNode* slow = head;
        ListNode* fast = head->next;
        
        while(fast != nullptr && fast->next != nullptr)
        {
            fast = fast->next->next;
            slow = slow->next;
        }
        
        ListNode* temp = slow->next;
        slow->next = nullptr;
        ListNode* reversed = reverse(temp);
        
        
        slow = head;
        
        while(reversed != nullptr)
        {
            if(reversed->val != slow->val)
            {
                return false;
            }
            
            reversed = reversed->next;
            slow = slow->next;
        }
        
        return true;
    }
    
    ListNode* reverse(ListNode* head)
    {
        if(head == nullptr || head->next == nullptr)
        {
            return head;
        }
        
        ListNode* reversed = reverse(head->next);
        head->next->next = head;
        head->next = nullptr;
        
        return reversed;
    }
};