package HashMap;

import java.util.*;

public class Map <K, V> {
    ArrayList<MapNode<K, V>> buckets;
    int size;
    int numbuckets;

    public Map() {
        buckets = new ArrayList<>();
        numbuckets = 5;
        for (int i = 0; i < 5; i++) {
            buckets.add(null);
        }
    }

    private int getBucketIndex(K key) {
        int hashCode = key.hashCode();
        return hashCode % numbuckets;
    }

    public void insert(K key, V value){
        int bucketIndex = getBucketIndex(key);
        MapNode<K,V> head = buckets.get(bucketIndex);
        while(head != null){
            if(head.key.equals(key)){
                head.value = value;
                return;
            }
            head = head.next;
        }
        head = buckets.get(bucketIndex);
        MapNode<K,V> newElementNode = new MapNode<K,V>(key, value);
        size++;
        newElementNode.next = head;
        buckets.set(bucketIndex, newElementNode);
        double loadFactor = (1.0 * size) / numbuckets;
        if(loadFactor > 0.7){
            rehash();
        }
    }

        public V getValue(K key){
            int bucketIndex = getBucketIndex(key);
            MapNode<K,V> head = buckets.get(bucketIndex);
            while(head != null){
                if(head.key.equals(key)){
                    return head.value;
                }
            head = head.next;
            }
            return null;
        }

        public V removeKey(K key){
            int bucketIndex = getBucketIndex(key);
            MapNode<K,V> head = buckets.get(bucketIndex);
            MapNode<K,V> prev = null;
            while(head != null){
                if(head.key.equals(key)){
                    if(prev == null){
                        buckets.set(bucketIndex, head.next);
                    }else {
                        prev.next = head.next;
                    }
                    return head.value;
                }
                prev = head;
                head = head.next;
            }
            return null;
        }

        public double loadFactor(){
            return (1.0 *size / numbuckets);
        }

        private void rehash() {
            System.out.println("Rehash: buckets" + numbuckets + " size " + size);
            ArrayList<MapNode<K,V>> temp = buckets;
            buckets = new ArrayList<>();
            for(int i =0; i< 2 * numbuckets; i++){
                buckets.add(null);
            }
            size = 0;
            numbuckets *= 2;
            for(int i =0; i<temp.size(); i++){
                MapNode<K,V> head = temp.get(i);
                while(head != null){
                    K key = head.key;
                    V value = head.value;
                    insert(key, value);
                    head = head.next;
                }
            }
        }
}
