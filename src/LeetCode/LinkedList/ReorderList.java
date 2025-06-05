package LeetCode.LinkedList;

public class ReorderList {
//    https://leetcode.com/problems/reorder-list/description/?envType=problem-list-v2&envId=oizxjoit



      public class ListNode {
          int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
      }

    class Solution {
        public void reorderList(ListNode head) {
            int n = getLength(head);

            int numberOfTimesOperationNeedsToBeDone = 0;
            if(n%2==0){
                numberOfTimesOperationNeedsToBeDone=n/2-1;
            }else{
                numberOfTimesOperationNeedsToBeDone=n/2;
            }
            ListNode currNode=head;


            while(numberOfTimesOperationNeedsToBeDone!=0){
                ListNode prev = null;
                ListNode temp = currNode;
                while(temp.next!=null){
                    prev= temp;
                    temp=temp.next;
                }
                prev.next=null;
                temp.next=currNode.next ;
                currNode.next = temp;
                numberOfTimesOperationNeedsToBeDone--;
                currNode =temp.next;
            }
        }

        public int getLength(ListNode head){
            if (head==null) return 0;
            int len = 1;
            while(head.next != null){
                head = head.next;
                len++;
            }
            return len;
        }
    }
}
