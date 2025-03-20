class MyHashMap {
int a[];
    public MyHashMap() {
        a=new int[1000001];
        Arrays.fill(a,-1);
    }
    
    public void put(int key, int value) {
        a[key]=value;
    }
    
    public int get(int key) {
        return a[key]>=0?a[key]:-1 ;
    }
    
    public void remove(int key) {
        a[key]=-1;
    }
}

