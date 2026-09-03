import java.util.*;

public class Hashmapdemo {
    public class Hashmap<K,V>{
        private class Node{
            K key;
            V value;
            Node(K key, V value){
                this.key = key;
                this.value = value;
            }
        }

        private int n;
        private int N = 4;
        private LinkedList<Node> buckets[];

        public Hashmap(){
            this.buckets = new LinkedList[N];
            for(int i=0;i<N;i++){
                buckets[i] = new LinkedList<Node>();
            }
        }

        private int hashFunc(K key){
            int ind = key.hashCode();
            return Math.abs(ind) % N;
        }

        private int searchLL(K key, int index){
            for(int i = 0; i<buckets[index].size(); i++){
                if(buckets[index].get(i).key == key){
                    return i;
                }
            }
            return -1;
        }

        private void rehash(){
            LinkedList<Node> arr[] = buckets;
            buckets = new LinkedList [N*2];
            for(int i=0;i<buckets.length;i++){
                buckets[i] = new LinkedList<Node>();
                buckets[i] = arr[i];
                for(int j=0;j<arr[i].size();j++){
                    Node data = arr[i].get(j);
                    buckets[i].add(data);
                }
            }
        }

        public void add(K key, V value){
            int bi = hashFunc(key);
            int di = searchLL(key , bi);

            if(di == -1){
                buckets[bi].add(new Node(key, value));
                n++;
            }
            else{
                Node n = buckets[bi].get(di);
                n.value = value;
            }

            double hash = (double)n/N;
            if(hash > 2.0){
                rehash();
            }
        }

        public void remove(K key){
            int bi = hashFunc(key);
            int di = searchLL(key , bi);

            if(di == -1){
                return;
            }
            else{
                buckets[bi].remove(di);
                n--;
            }
        }

        public boolean contains(K key){
            int bi = hashFunc(key);
            int di = searchLL(key , bi);

            if(di == -1){
                return false;
            }
            else{
                return true;
            }
        }

        @Override
        public String toString(){
            String result = "{";

            for(int i=0;i< buckets.length;i++){
                for(int j=0;j<buckets[i].size();j++){
                    Node res = buckets[i].get(j);
                    result += ""+ res.key+":"+res.value+" ";
                }
            }
            result += "}";
            return result;
        }

        public ArrayList<K> keys(){
            ArrayList<K> keyset = new ArrayList<>();
            for(int i=0;i< buckets.length;i++){
                for(int j=0;j<buckets[i].size();j++){
                    keyset.add(buckets[i].get(j).key);
                }
            }
            return keyset;
        }

        public ArrayList<V> values(){
            ArrayList<V> valueset = new ArrayList<>();

            for(int i=0;i< buckets.length;i++){
                for(int j=0;j<buckets[i].size();j++){
                    valueset.add(buckets[i].get(j).value);
                }
            }
            return valueset;
        }

        public boolean isEmpty(){
            return n==0;
        }
    }


    public void main(String[] args){
        Hashmap<String, Integer> map = new Hashmap<>();

        map.add("India", 200);
        map.add("China", 150);
        map.add("China", 170);
        map.remove("China");
        map.remove("India");

        System.out.println("Is the map empty?:"+map.isEmpty());


    }
}
