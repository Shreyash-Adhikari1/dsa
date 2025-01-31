public class LinearProbing {
    int keys[];
    int values[];
    int capacity;

    public LinearProbing(int capacity){
        this.capacity = capacity;
        keys = new int[capacity];
        values = new int[capacity];
        for(int i = 0; i < keys.length; i++){
            keys[i] = -1;
            values[i] = -1;
        }
    }

    void insert(int key, int value){
        int i = hashFun(key);
        if(keys[i] == -1){
            keys[i] = key;
            values[i] = value;
        } else{
            // probing
            int tmp = 1;
            do{
                i = (i +1)%capacity;
                if(keys[i] == -1){
                    keys[i] = key;
                    values[i] = value;
                }
            } while(tmp != 1);
        }
    }

    int get(int key){
        int i = hashFun(key);
        if(keys[i] == key){
            return values[i];
        } else{
            int tmp = 1;
            do{
                i = (i +1)%capacity;
                if(keys[i] == -1){
                    return values[i];
                }
            } while(tmp != 1);
        }
        return -1;
    }

    int hashFun(int key){
        return key % capacity;  // you can use any hash function here for eg: (key*2+3)%capacity
    }

}