class Node{
    HashMap<Integer,Integer> count;
    Node(int val){
        count=new HashMap<Integer,Integer>();
        count.put(val,1);
    }
    Node(HashMap<Integer,Integer>mp,HashMap<Integer,Integer> mp2){
        count=new HashMap<Integer,Integer>(mp);
        mp2.forEach((key,val)->
        count.merge(key,val,Integer::sum));
    }
}
class RangeFreqQuery {
Node seg[];
int n;
    public RangeFreqQuery(int[] arr) {
        n=arr.length;
        seg=new Node[4*n];
build(0,0,n-1,seg,arr);
    }
    
    public int query(int left, int right, int value) {





        return helper(0,n-1,left,right,value,0);
    }
    public int helper(int st,int end,int l,int r,int v,int node){
        //no overlap 
        if(r<st || l>end) return 0;
        //total overlap
        //count total number of times a value 'v' has appeared
        if(l<=st && end <= r)
            return seg[node].count.getOrDefault(v,0);

        //partial overlap
        int mid = (st+end)/2;
        int a = helper(st,mid,l,r,v,node*2+1);
        int b = helper(mid+1,end,l,r,v,node*2+2);
        return a+b;}
    public void build(int idx,int l,int h,Node seg[],int a[]){
        if(l==h){
            seg[idx]=new Node(a[l]);
            return;
        }
     int mid=(l+h)/2;
     build(2*idx+1,l,mid,seg,a);
     build(2*idx+2,mid+1,h,seg,a);
     seg[idx]=new Node(seg[2*idx+1].count,seg[2*idx+2].count);

     
    }
}

/**
 * Your RangeFreqQuery object will be instantiated and called as such:
 * RangeFreqQuery obj = new RangeFreqQuery(arr);
 * int param_1 = obj.query(left,right,value);
 */