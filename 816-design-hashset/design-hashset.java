class MyHashSet {
    boolean a[];

    public MyHashSet() {
        a = new boolean[1000001]; // Use boolean instead of int
    }

    public void add(int key) {
        a[key] = true;
    }

    public void remove(int key) {
        a[key] = false; // Instead of decrementing, just mark it as false
    }

    public boolean contains(int key) {
        return a[key]; // Boolean check is enough
    }
}
