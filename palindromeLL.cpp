// Time Complexity : O(n); n is number of rows
// Space Complexity : O(1); 
// Did this code successfully run on Leetcode : Yes (fails for one test case, trying to resolve that)
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
// 1. Find middle of LL, reverse second half and compare with first half
// 2. If there is any mismatch in comparison, return false

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
        if(head == nullptr || head->next==nullptr)
            return true;
        if(head->next->next == nullptr && head->val!=head->next->val)
            return false;
        else
            return true;
        //mid
        ListNode* curr=head;
        int length = 0;
        while(curr != nullptr){
            curr=curr->next;
            length++;
        }
        int mid = length/2;
        curr=head;
        //reverse
        for(int i=0;i<=mid; i++){
            curr=curr->next;
        }
       
        ListNode* list2 = reverse(curr);
       
        curr=head; 
        //compare
        
        while(list2!=nullptr){
            cout<<curr->val<<" "<<list2->val<<endl;
            if(curr->val != list2->val)
                return false;
            curr=curr->next;
            list2=list2->next;
        }
        
        return true;
    }
    
    ListNode* reverse(ListNode* head){
        if(head==nullptr)
            return head;
        ListNode* prev = nullptr;
        ListNode* curr = head;
        ListNode* target = head->next;
        while(curr->next!=nullptr){
            curr->next=prev;
            prev=curr;
            curr=target;
            target=target->next;
        }
        curr->next=prev;
        return curr;
    }
};