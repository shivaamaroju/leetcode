class LRUCache {
    opp k;
    Map<Integer,Node> mp;
    int size;
    int capacity;
    public LRUCache(int capacity) {
        k=new opp();
        this.size=0;
        this.capacity=capacity;
        mp=new HashMap<>();
    }
    
    public int get(int key) {
        if(!mp.containsKey(key))return -1;
        Node ans=mp.get(key);
        k.moveFront(ans);
        return ans.value;
    }
    
    public void put(int key, int value) {
         if(mp.containsKey(key)){
            Node nn=mp.get(key);
                nn.value=value;  
                k.moveFront(nn);
        }
        
        else{
            if(size<capacity){ 
            Node nn= k.addAtHead(key,value);
            mp.put(key,nn);
            size++;
        }
        else{
             int p=k.deleteAtLast();
             mp.remove(p);
            Node nn= k.addAtHead(key,value);
            mp.put(key,nn);
            

                }
        }
    }
}
class opp{
    Node head;
    public opp(){
        head=null;
    }
    Node addAtHead(int key,int value){
        Node nn=new Node(key,value);
        nn.next=nn;
        nn.prev=nn;
        if(head==null){
            head=nn;
            return nn;
        } 
        Node last=head.prev;
        nn.next=head;
        head.prev=nn;
        nn.prev=last;
        last.next=nn;
        head=nn;
        return nn;
    }

    int deleteAtLast(){
        if(head==null)return -1;
        Node last=head.prev;
        if(head==last){
            head=null;
            return last.key;
        }
        Node last_scnd=last.prev;
        last_scnd.next=head;
        head.prev=last_scnd;
        return last.key;
    }
    void moveFront(Node nn){
      if(head==nn)return ;
        nn.prev.next=nn.next;
        nn.next.prev=nn.prev;
        Node last= head.prev;
        last.next=nn;
        nn.next=head;
        head.prev=nn;
        nn.prev=last;
        head=nn;
        return ;        
    }

}
class Node{
    int key,value;
    Node prev,next;
    Node(int k,int v){
        key=k;
        value=v;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */