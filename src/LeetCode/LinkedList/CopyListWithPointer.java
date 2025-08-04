package LeetCode.LinkedList;

import java.util.HashMap;
import java.util.Map;

public class CopyListWithPointer {


//    https://leetcode.com/problems/copy-list-with-random-pointer/description/


class Node {
        int val;
        Node next;
        Node random;

    public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    class Solution {
        public Node copyRandomList(Node head) {
            Map<Node , Node> mpp = new HashMap<>();


            Node curr = head;

            while(curr != null){
                mpp.put(curr , new Node(curr.val));
                curr = curr.next;
            }
            curr = head ;
            while(curr!= null){
                Node copy = mpp.get(curr);
                copy.next = mpp.get(curr.next);
                copy.random = mpp.get(curr.random);
                curr = curr.next;
            }

            return mpp.get(head);

        }
    }

// this is more space optimised approach
//    this is just copied here

        public Node copyRandomList(Node head) {
            if (head == null) return null;

            // Step 1: Clone nodes and interleave with original list
            Node curr = head;
            while (curr != null) {
                Node next = curr.next;
                Node copy = new Node(curr.val);
                curr.next = copy;
                copy.next = next;
                curr = next;
            }

            // Step 2: Assign random pointers to the cloned nodes
            curr = head;
            while (curr != null) {
                if (curr.random != null) {
                    curr.next.random = curr.random.next;
                }
                curr = curr.next.next;
            }

            // Step 3: Separate the original and cloned list
            curr = head;
            Node pseudoHead = new Node(0);
            Node copyCurr = pseudoHead;

            while (curr != null) {
                Node next = curr.next.next;

                // extract the copy
                Node copy = curr.next;
                copyCurr.next = copy;
                copyCurr = copy;

                // restore original list
                curr.next = next;
                curr = next;
            }

            return pseudoHead.next;
        }
    }

