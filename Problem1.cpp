// Time Complexity : O(n) n is list size(# of nodes).
// Space Complexity : O(1) .
// Did this code successfully run on Leetcode : Yes 


// Your code here along with comments explaining your approach:
// 1. Traverse till mid element using hire and tortoise technic and store next element in temp.
// 2. Point mid to null and traverse second half to reverse second half of the list.
// 3. we will get 2 list now check if both list(first half and reversed half) values are equal return true if equal elase false.

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
        if( (head==nullptr) || (head->next == nullptr) ){
            return 1;
        }
        ListNode* s=head;
        ListNode* f=head;
        bool flag=0;
        while(f->next!=nullptr){
            if(flag==1){
                s=s->next;
            }
            f=f->next;flag=!flag;
        }
        f=(s->next);
        (s->next)=nullptr;
        ListNode* prev=nullptr;
        while(f->next!=nullptr){
            ListNode* tt=f->next;
            (f->next)=prev;
            prev=f;
            f=tt;
        }
        (f->next) = prev;
        while(f!=nullptr){
            if((f->val)!=(head->val)){
                return 0;
            }
            f=(f->next);head=(head->next);
        }

        return 1;
    }
};