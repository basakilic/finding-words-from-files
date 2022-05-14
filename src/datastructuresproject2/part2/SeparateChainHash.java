package datastructuresproject2.part2;

import java.util.LinkedList;

public class SeparateChainHash<Key,Item> {
    int M;
    
    Entry<Key,Item>[] table;
    
    public SeparateChainHash(int M){
        table = new Entry[M];
        for(int ix = 0; ix < M; ix++)
            table[ix] = new Entry<Key,Item>(null);
        this.M = M;
    }
    
    private class Entry<Key,Item>{
        Key key;
        LinkedList<Item> values;

        public Entry(Key key) {
            this.key = key;
            this.values = new LinkedList();
        }

        public LinkedList<Item> getValues() {
            return values;
        }
        
        public void addValue(Item value){
            if(values.indexOf(value) == -1)
                values.add(value);
        }

        public Key getKey() {
            return key;
        }

        @Override
        public String toString() {
            return  key +"  --> " + values.toString();
        }        
    }
    
    public int hash(Key k){
        return ((k.hashCode() & 0x7ffffff) % M);
    }
    
    private LinkedList<Item> returnValues(int current, Key k){
       if(table[current].key == null){
          return null;
         }else{
             if(table[current].key.equals(k))
                 return table[current].getValues();
             else {
                 current++;
                 if(current == hash(k)){
                 return null;
                 }
                 if(current > M)
                     current = 0;
                 return returnValues(current,k);
             }
         }
    }
    
    public LinkedList<Item> returnValues(Key k){
        return returnValues(hash(k),k);
    }
    
    public void insert(Key k, Item t){
        insert(hash(k),k,t);
    }
    
    private void insert(int current, Key k, Item t){
         if(table[current].key == null){
            table[current] = new Entry<Key,Item>(k);
            table[current].addValue(t); // add file name 
         }else{
             if(table[current].key.equals(k)){
                table[current].addValue(t); // add other file names
             } else {
                 current++;
                 if(current == hash(k)){
                 return;
                 }
                 if(current > M)
                     current = 0;
                 insert(current,k,t);
             }
         }
    }
    
    public String toString(){
        String s = "";
        for (int ix = 0; ix < M; ix++){
            if (table[ix].key != null)
                s +=  table[ix].toString() +"\n";
        }
        return s;
    }
}