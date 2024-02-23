// Time Complexity : O(N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

// we traverse till mid and reverse the second half of the list.
// we compare one by one node and check if its a palindrome.

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
    ListNode* reverseList(ListNode* head)
    {
        if(head ==NULL){
            return head;
        }
        ListNode* curr = head;
        ListNode * temp = NULL;
        ListNode * prev = NULL;
        while(curr!=NULL)
        {
            temp = curr->next;
            curr->next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;  
    }

    
    bool isPalindrome(ListNode* head) {
        if(head == NULL){
            return false;
        }
        ListNode* s = head;
        ListNode* f = head;
        ListNode* prev = NULL;
        while(f!=NULL && f->next!=NULL)
        {
            s = s->next;
            f = f->next->next;
        }
        s = reverseList(s);
        while(head!=NULL && s!=NULL)
        {
           // cout << "head val "<< head->val << "  s val " << s->val<< "   ";
            if(head->val != s->val)
            {
                return false;
            }
            head= head->next;
            s= s->next;
        }
        return true;
    }
};