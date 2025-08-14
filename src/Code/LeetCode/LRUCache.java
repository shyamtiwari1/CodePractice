package Code.LeetCode;

class LRUCache {

    public LRUCache(int capacity) {

    }

    public int get(int key) {
        return 0 ;
    }

    public void put(int key, int value) {

    }

    class Node{
        public void Node(int data) {
            this.data = data;
        }

        int data ;
        Node prev ;
        Node next;


    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
