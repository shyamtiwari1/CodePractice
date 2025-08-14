package Code.LeetCode.LinkedList;

public class ReorderList {
//    https://leetcode.com/problems/reorder-list/description/



      public class ListNode {
          int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
      }

    class Solution {

/***
 * in the optimised solution we're first fetching the middle of list the reversing the list from that second half
 * the we merge alternatively , this will take o(n) time
 */


            public void reorderListoptimised(ListNode head) {

                ListNode slow = head;
                ListNode fast = head;

                while(fast!=null && fast.next!=null){
                    slow = slow.next;
                    fast = fast.next.next;
                }

                ListNode second = slow.next;
                slow.next = null;
                second = reverseList(second);
                ListNode first = head;

                while(second!=null){
                    ListNode temp1 = first.next ;
                    ListNode temp2 = second.next;

                    first.next = second;
                    second.next = temp1;
                    first = temp1;
                    second = temp2;


                }

            }

            public ListNode reverseList(ListNode head){
                ListNode temp = head ;
                ListNode prev = null;

                while(temp!=null){
                    ListNode nextnode = temp.next;
                    temp.next = prev ;
                    prev = temp ;
                    temp = nextnode;
                }
                return prev;
            }
        }





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

