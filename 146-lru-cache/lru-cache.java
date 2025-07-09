import java.util.*;
class LRUCache {
    LinkedHashMap<Integer,Integer> q;
    int r;
    public LRUCache(int s) {
        r=s;
        q=new LinkedHashMap<>(s,0.75f,true){
            protected boolean removeEldestEntry(Map.Entry<Integer,Integer> e){
                return size()>r;
            }
        };
    }
    public int get(int x) {
        return q.getOrDefault(x,-1);
    }
    public void put(int x, int y) {
        q.put(x,y);
    }
}
