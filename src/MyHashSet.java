import java.util.Arrays;

class MyHashSet {

    /** Initialize your data structure here. */
    public int[] set ;
    public MyHashSet() {

    }
    public void add(int key) {

        for(int i=0;i<set.length;i++){
            if(key==i)
                return;
        }
        int j = set.length;
        set[j] = key;
    }

    public void remove(int key) {
        for(int i=0;i<set.length;i++){
            if(set[i]==key){
                set[i] = set[set.length-1];
                set = Arrays.copyOf(set,set.length-1);
            }

        }

    }

    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        for(int i:set){
            if(key==i)
                return true;
        }
        return false;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */
