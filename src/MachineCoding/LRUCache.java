package MachineCoding;

import java.util.HashMap;
import java.util.Map;

class LRUCache {

//    https://leetcode.com/problems/lru-cache/description/

    public class Node{
        int key ;
        int val ;
        Node prev;
        Node next ;
        public Node(int key , int val){
            this.key = key ;
            this.val = val ;
        }
    }

    Map<Integer , Node> mpp = new HashMap<>();
    Node head = new Node(-1 , -1);
    Node tail = new Node(-1 , -1);
    int capacity ;

    public LRUCache(int capacity) {
        this.capacity = capacity ;
        head.next = tail ;
        tail.prev = head;
    }

    public int get(int key) {

        if(!mpp.containsKey(key)){
            return -1;
        }else{
            Node node = mpp.get(key);
            deleteNode(node);
            insertAfterHead(node);
            return node.val ;
        }

    }

    public void put(int key, int value) {
        Node node = new Node(key, value);
        if(!mpp.containsKey(key)){
            if(mpp.size()<capacity){
                // Node node = new Node(key, value);
                mpp.put(key , node);
                insertAfterHead(node);
            }else{
                Node lruNode = tail.prev;
                deleteNode(lruNode);
                insertAfterHead(node);
                mpp.remove(lruNode.key);
                mpp.put(key , node);
            }

        }else{
            node = mpp.get(key);
            node.val = value;
            deleteNode(node);
            insertAfterHead(node);
        }

    }

    public void insertAfterHead(Node node){
        Node currAfterhead = head.next ;
        head.next = node ;
        node.next = currAfterhead;
        currAfterhead.prev = node;
        node.prev = head;
    }
    public void deleteNode(Node node){
        Node prevNode = node.prev;
        Node afterNode = node.next ;
        prevNode.next = afterNode;
        afterNode.prev = prevNode;

    }
}

/**
 * Your MachineCoding.LRUCache object will be instantiated and called as such:
 * MachineCoding.LRUCache obj = new MachineCoding.LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
