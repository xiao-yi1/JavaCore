package 特殊的数据结构;

import java.util.HashMap;
import java.util.Map;

class LRUCache {
    //14:30 - 14:55 看的题解，懂了，mark一下2022/2/24
    //11:03-
    int capacity = 0;
    int size = 0;
    Map<Integer,Node> map;
    Node tail;
    Node head;
    class Node{
        int key;
        int value;
        Node pre = null;
        Node next = null;
        public Node(){

        }
        public Node(int _key,int _value){
            key = _key;
            value = _value;
        }
    }

    public LRUCache(int capacity) {
        this.capacity = capacity+2;
        map  = new HashMap<>();
        head = new Node(-1,-1);
        tail = new Node(-2,-2);
        head.next = tail;
        tail.pre = head;
        map.put(-1,head);
        map.put(-2,tail);
        size+=2;
    }

    public int get(int key) {
        if(map.get(key)==null)return -1;
        Node cur = map.get(key);
        moveTohead(cur);
        return cur.value;
    }

    public void put(int key, int value) {
        if(size==capacity){
            map.remove(removeLast().key);
            --size;
        }
        Node a = new Node(key,value);
        addTohead(a);
        map.put(key,a);
        ++size;
    }
    public void moveTohead(Node cur){
        nodeRemove(cur);
        addTohead(cur);
    }
    public void nodeRemove(Node cur){
        Node pre = cur.pre;
        Node next = cur.next;
        pre.next = next;
        next.pre = pre;
        map.remove(cur);
    }
    public void addTohead(Node cur){
        Node next = head.next;
        head.next = cur;
        cur.pre = head;
        cur.next = next;
        next.pre = cur;
    }
    public Node removeLast(){
        Node cur = tail.pre;
        Node pre = cur.pre;
        pre.next = tail;
        tail.pre = pre;
        cur.next = null;
        cur.pre = null;
        return cur;
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);
        cache.put(1,1);
        cache.put(2,2);
        System.out.println(cache.get(1));
        cache.put(3,3);
        System.out.println(cache.get(2));
        cache.put(4,4);
        System.out.println(cache.get(1));
        System.out.println(cache.get(3));
        System.out.println(cache.get(4));
    }
}

/**
 * Your 特殊的数据结构.LRUCache object will be instantiated and called as such:
 * 特殊的数据结构.LRUCache obj = new 特殊的数据结构.LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
