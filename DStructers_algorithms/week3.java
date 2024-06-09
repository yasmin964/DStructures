//package DStructers_algorithms;
//
//import java.util.List;
//import java.util.ArrayList;
//import java.util.Scanner;
//import java.util.LinkedList;
//
//public class week3 {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        sc.nextLine();
//        String expression1 = sc.nextLine();
//        HashMap<String, Integer> map1 = countOfWords(expression1);
//
//        int m = sc.nextInt();
//        sc.nextLine();
//        String[] secondText = sc.nextLine().split(" ");
//        printUniqueWords(map1, secondText);
//
//
//
//    }
//
//    interface Map<K, V> {
//        int size();
//
//        boolean isEmpty();
//
//        V get(K key);
//
//        void put(K key, V value);
//
//        void remove(K key);
//
//    }
//
//    static class Entry<K, V> {
//        K key;
//        V value;
//
//        public Entry(K key, V value) {
//            this.key = key;
//            this.value = value;
//        }
//
//        public K getKey() {
//            return key;
//        }
//
//        public void setKey(K key) {
//            this.key = key;
//        }
//
//        public V getValue() {
//            return value;
//        }
//
//        public void setValue(V value) {
//            this.value = value;
//        }
//    }
//
//    static class HashMap<K, V> implements Map<K, V> {
//        List<Entry<K, V>>[] hashTable;
//        int capacity;
//        int numberOfElements;
//
//        public HashMap(int capacity) {
//            this.capacity = capacity;
//            this.numberOfElements = 0;
//            this.hashTable = new List[capacity];
//            for (int i = 0; i < capacity; i++) {
//                this.hashTable[i] = new LinkedList<>();//Separating Chain
//            }
//        }
//
//        private Entry<K, V> getEntry(K key) {
//            int hash = Math.abs(key.hashCode()) % capacity;
//            for (Entry entry : hashTable[hash]) {
//                if (entry.key.equals(key)) {
//                    return entry;
//                }
//            }
//            return null;
//        }
//
//        @Override
//        public V get(K key) {
//            int hash = Math.abs(key.hashCode()) % capacity;
//            for (Entry<? extends K, ? extends V> entry : hashTable[hash]) {
//                if (entry.key.equals(key)) {
//                    return entry.getValue();
//                }
//            }
//            return null;
//        }
//
//        @Override
//        public void put(K key, V value) {
//            int hash = Math.abs(key.hashCode()) % capacity;
//            Entry<K, V> e = getEntry(key);
//            if (e != null) {
//                e.setValue(value);
//            } else {
//                this.hashTable[hash].add(new Entry<>(key, value));
//                this.numberOfElements++;
//            }
//        }
//
//        @Override
//        public void remove(K key) {
//            int hash = Math.abs(key.hashCode()) % capacity;
//            Entry<K, V> e = null;
//            for (Entry<K, V> entry : hashTable[hash]) {
//                if (entry.getKey() == key) {
//                    e = entry;
//                }
//            }
//            if (e != null) {
//                hashTable[hash].remove(e);
//                numberOfElements--;
//            }
//        }
//
//        @Override
//        public int size() {
//            return this.numberOfElements;
//        }
//
//        @Override
//        public boolean isEmpty() {
//            return (this.numberOfElements == 0);
//        }
//    }
//    static List<String> printUniqueWords (HashMap<String, Integer> wordCount1, String [] words ){
//        List<String> uniqueWords = new ArrayList<>();
//        for (String word : words){
//                int k1 = wordCount1.get(word)!= null ? wordCount1.get(word) : 0 ;
//
//                if( k1 == 0 ){// те слово из 2 НЕ содержится в 1
//                    uniqueWords.add(word);
//                    wordCount1.put(word, 1);
//                }
//            }
//        System.out.println(uniqueWords.size());
//
//
//        for(String res : uniqueWords){
//            System.out.println(res);
//        }
//        return uniqueWords;
//    }
//    static HashMap<String, Integer> countOfWords(String expression){
//        String []tokens = expression.split(" ");//относится к 1 выражению
//        HashMap<String, Integer> wordCount = new HashMap<>(tokens.length);
//        for(String token:tokens){
//            if(wordCount.get(token) != null){//если в map2 есть какое то слово из 1
//                wordCount.put(token, wordCount.get(token) + 1);
//            }else{
//                wordCount.put(token, 1);
//            }
//        }return wordCount;
//    }
//}
//
//
//
