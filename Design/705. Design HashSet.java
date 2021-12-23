class MyHashSet {
    int hash;
    ArrayList<Bucket> hashTable;
    
    class Bucket{
        private List<Integer> bucket;
        
        Bucket(){
            this.bucket = new LinkedList<Integer>();
        }
        
        public void delete(int key){
            if(this.bucket.contains(key)) {
                int index = this.bucket.indexOf(key);
                this.bucket.remove(index);
            }       
        }
        
        public void add(int key){
            if(!bucket.contains(key)) bucket.add(key);
        }
        
        public boolean get(int key){
            return bucket.contains(key);
        }
        
    }

    public MyHashSet() {
        this.hash = 2069;
        this.hashTable = new ArrayList<>();
        for(int i=0;i<2069;i++){
            this.hashTable.add(new Bucket());
        }
    }    
    
    public void add(int key) {
        int hashKey = key%this.hash;
        Bucket bucket = this.hashTable.get(hashKey);
        bucket.add(key);
    }
    
    public void remove(int key) {
        int hashKey = key%this.hash;
        Bucket bucket = this.hashTable.get(hashKey);
        bucket.delete(key);
    }
    
    public boolean contains(int key) {
        int hashKey = key%this.hash;
        Bucket bucket = this.hashTable.get(hashKey);
        return bucket.get(key);
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */
