class MyHashMap {
    int hash;
    ArrayList<Bucket> hashTable;
    
    class Pair{
        public int key;
        public int value;
        
        Pair(int key, int value){
            this.key = key;
            this.value = value;
        }
    }
    
    class Bucket{
        private List<Pair> bucket;
        
        Bucket(){
            this.bucket = new ArrayList<Pair>();
        }
        
        public void remove(int key){
            for(Pair pair : bucket){
                if(pair.key==key) {
                    this.bucket.remove(pair);
                    break;
                }
            }
        }
        
        public void add(int key, int value){
            bucket.add(new Pair(key, value));
        }
        
        public void update(int key, int value){
            boolean found = false;
            for(Pair pair : bucket){
                if(pair.key==key) {
                    pair.value = value;
                    found = true;
                    break;
                }
            }
            if(!found) add(key, value);
        }
        
        public int get(int key){
            for(Pair pair : bucket){
                if(pair.key==key) return pair.value;
            }
            return -1;
        }
        
    }

    public MyHashMap() {
        this.hash = 2069;
        this.hashTable = new ArrayList<>();
        for(int i=0;i<2069;i++){
            this.hashTable.add(new Bucket());
        }
    }

    public MyHashMap(int hash){
        this.hash = hash;
        this.hashTable = new ArrayList<>();
        for(int i=0;i<this.hash;i++){
            this.hashTable.add(new Bucket());
        }
    }
    
    
    public void put(int key, int value) {
        int hashKey = key%this.hash;
        Bucket bucket = this.hashTable.get(hashKey);
        bucket.update(key, value);
    }
    
    public int get(int key) {
        int hashKey = key%this.hash;
        Bucket bucket = this.hashTable.get(hashKey);
        return bucket.get(key);
    }
    
    public void remove(int key) {
        int hashKey = key%this.hash;
        Bucket bucket = this.hashTable.get(hashKey);
        bucket.remove(key);
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */
