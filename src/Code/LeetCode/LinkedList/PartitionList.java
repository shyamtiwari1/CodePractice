package Code.LeetCode.LinkedList;

public class PartitionList {

//    https://leetcode.com/problems/partition-list/description/



    class Solution {
        public ListNode partition(ListNode head, int x) {

            ListNode head1 = new ListNode(-1);
            ListNode head1head = head1;

            ListNode head2 = new ListNode(-1);
            ListNode head2head = head2;
            // ListNode dummy = newhead;
            ListNode curr = head;

            while(curr!=null){
                if(curr.val<x){
                    head1.next  = curr;
                    head1 = head1.next;
                }else{
                    head2.next = curr;
                    head2 = head2.next;
                }
                curr=curr.next;
            }
            head2.next = null;
            head1.next = head2head.next;
            return head1head.next;

        }
    }
}
