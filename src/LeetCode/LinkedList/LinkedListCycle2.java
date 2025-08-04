package LeetCode.LinkedList;

public class LinkedListCycle2 {

//    https://leetcode.com/problems/linked-list-cycle-ii/description/

/***
 * this solution is that first we go to the meeting point of fast and slow pointer
 * once reached there , take one pointer to head again and start both pointer one step at a time
 * now when they meet it's the start of the list
 *
 * so when slow and fast pointer meets , that means fast has completed certain loops of cycle ,
 * and first has moved 2 time the distance of slow lets say slow moved d and fast moved 2d
 * 2d-d = n*cycle length
 * d = nc
 *
 *
 *
 *
 */
    /
    public class Solution {
        public ListNode detectCycle(ListNode head) {


            ListNode slow = head;
            ListNode fast = head;

            while(fast!=null && fast.next!=null){
                slow = slow.next;
                fast = fast.next.next;

                if(slow==fast){
                    fast = head ;
                    while(fast!=slow){
                        slow = slow.next ;
                        fast = fast.next;
                    }
                    return slow;

                }
            }
            return null;

        }
    }
}
