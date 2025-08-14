package Code.LeetCode.LinkedList;

public class MergeTwoSortedLinkedList {
//    https://leetcode.com/problems/merge-two-sorted-lists/description/


    class Solution {
        public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

            if(list1==null){
                return list2;
            }
            if(list2==null){
                return list1;
            }
            ListNode head = new ListNode(-1);
            ListNode dummy = head;

            while(list1!=null && list2!=null){
                if(list1.val>list2.val){
                    dummy.next = list2;
                    list2=list2.next;
                }else{
                    dummy.next = list1;
                    list1=list1.next;
                }
                dummy = dummy.next;
            }
            if(list1==null){
                dummy.next = list2;
            }
            if(list2==null){
                dummy.next = list1;
            }

            return head.next;

        }
    }
}
