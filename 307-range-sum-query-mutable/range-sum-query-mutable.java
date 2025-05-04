class NumArray {
int seg[],a[];
int n;
    public NumArray(int[] nums) {
        n=nums.length;
        seg=new int[4*nums.length];
        a=new int[nums.length];
        for(int i=0;i<nums.length;i++)a[i]=nums[i];
        build(0,0,n-1);
    }
    public void build(int idx,int l,int r){
        if(l==r){
            seg[idx]=a[l];
        return;
        }
        int mid=(l+r)/2;
        build(2*idx+1,l,mid);
        build(2*idx+2,mid+1,r);
        seg[idx]=seg[2*idx+1]+seg[2*idx+2];

    }
    
    public void update(int i, int val) {
       updatetil(0,0,n-1,i,val); 
    }
    public void updatetil(int idx,int l,int r,int i,int val){
        if(l==r){
            seg[idx]=val;
            return;
        }
        int mid=(l+r)/2;
        if(i<=mid)updatetil(2*idx+1,l,mid,i,val);
        else updatetil(2*idx+2,mid+1,r,i,val);
        seg[idx]=seg[2*idx+1]+seg[2*idx+2];
    }
    
    public int sumRange(int left, int right) {
      return query(0,0,n-1,left,right);  
    }
    public int query(int idx,int l,int r,int left,int right){
        if(right<l||r<left)return 0;
        if(left<=l&&right>=r)return seg[idx];
        int mid=(l+r)/2;
        int x=query(2*idx+1,l,mid,left,right);
        int y=query(2*idx+2,mid+1,r,left,right);
        return x+y;
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */