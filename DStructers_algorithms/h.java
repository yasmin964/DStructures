//package DStructers_algorithms;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.LinkedList;
//import java.util.Scanner;
//
//public class Main {
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//
//        int numOfStudents = scanner.nextInt();
//        scanner.nextLine(); // Consume the newline
//
//        Map<Integer, String> studentScoresMap = new HashMap<>(10000);
//        List<Integer> scores = new ArrayList<>();
//
//        // Reading student data and adding to HashMap
//        for (int i = 0; i < numOfStudents; i++) {
//            String[] studentDetails = scanner.nextLine().split(" ");
//            int studentScore;
//            try {
//                studentScore = Integer.parseInt(studentDetails[0]);
//            } catch (NumberFormatException e) {
//                System.out.println("0");
//                continue;
//            }
//            scores.add(studentScore);
//            studentScoresMap.put(studentScore, studentDetails[1] + " " + studentDetails[2]);
//        }
//
//        int middleIndex = numOfStudents / 2;
//        nthSmallest(scores, middleIndex);
//        int medianScore = scores.get(middleIndex);
//        String studentInfo = studentScoresMap.get(medianScore);
//
//        if (studentInfo != null) {
//            System.out.println(studentInfo);
//        } else {
//            System.out.println("Student information not found for score " + medianScore);
//        }
//    }
//
//    public static int select(List <Integer>scores, int left, int right, int k) {
//        if (left == right) {
//            return scores.get(left);
//        }
//
//        int num = right - left + 1;
//        int groupsN = (num + 4) / 5;
//        List<Integer> groupsM = new ArrayList<>();
//
//        for (int i = 0; i < groupsN; i++) {
//            int groupLeft = left + i * 5;
//            int groupRight = Math.min(left + i * 5 + 4, right);
//            groupsM.add(partition5(scores, groupLeft, groupRight));
//        }
//
//        int medians = (groupsN == 1) ? groupsM.get(0) : select(groupsM, 0, groupsN - 1, groupsN / 2);
//
//        int pivotIndex = partition(scores, left, right, medians);
//
//        if (k == pivotIndex) {
//            return scores.get(k);
//        } else if (k < pivotIndex) {
//            return select(scores, left, pivotIndex - 1, k);
//        } else {
//            return select(scores, pivotIndex + 1, right, k);
//        }
//    }
//    public static int nthSmallest(List scores, int k) {
//        return select(scores, 0, scores.size() - 1, k);
//    }
//
//    public static int partition(List <Integer>scores, int left, int right, int pivot) {
//        int i = left;
//        for (int j = left; j < right; j++) {
//            if (scores.get(j) == pivot) {
//                int temp = scores.get(j);
//                scores.set(j, scores.get(right));
//                scores.set(right, temp);
//            }
//            if (scores.get(j) < pivot) {
//                int temp = scores.get(i);
//                scores.set(i, scores.get(j));
//                scores.set(j, temp);
//                i++;
//            }
//        }
//        int temp = scores.get(i);
//        scores.set(i, scores.get(right));
//        scores.set(right, temp);
//        return i;
//    }
//    public static int partition5(List<Integer> scores, int left, int right) {
//        List <Integer> sub = new ArrayList<>();
//        for (int i = left; i <= right; i++) {
//            sub.add(scores.get(i));
//        }
//        int num = right - left + 1;
//
//        for (int i = 0; i < num - 1; i++) {
//            for (int j = 0; j < num - i - 1; j++) {
//                if (sub.get(j) > sub.get(j + 1)) {
//                    int temp = sub.get(j);
//                    sub.set(j, sub.get(j + 1));
//                    sub.set(j + 1, temp);
//                }
//            }
//        }
//        return sub.get(num / 2);
//    }
//
//
//}
//
//interface Map<K, V> {
//    int size();
//    boolean isEmpty();
//    V get(K key);
//    void put(K key, V value);
//    void remove(K key);
//    List<K> keyList();
//}
//
//class Entry<K, V> {
//    K key;
//    V value;
//
//    public Entry(K key, V value) {
//        this.key = key;
//        this.value = value;
//    }
//
//    public K getKey() {
//        return key;
//    }
//
//    public void setKey(K key) {
//        this.key = key;
//    }
//
//    public V getValue() {
//        return value;
//    }
//
//    public void setValue(V value) {
//        this.value = value;
//    }
//}
//
//class HashMap<K, V> implements Map<K, V> {
//    List<Entry<K, V>>[] hashTable;
//    int capacity;
//    int numberOfElements;
//
//    public HashMap(int capacity) {
//        this.capacity = capacity; // Initialize the capacity
//        this.numberOfElements = 0;
//        this.hashTable = new List[capacity];
//        for (int i = 0; i < capacity; i++) {
//            this.hashTable[i] = new LinkedList<>();
//        }
//    }
//
//    private Entry<K, V> getEntry(K key) {
//        int hash = Math.abs(key.hashCode()) % capacity;
//        for (Entry entry : hashTable[hash]) {
//            if (entry.key.equals(key)) {
//                return entry;
//            }
//        }
//        return null;
//    }
//
//    @Override
//    public V get(K key) {
//        int hash = Math.abs(key.hashCode()) % capacity;
//        for (Entry<? extends K, ? extends V> entry : hashTable[hash]) {
//            if (entry.key.equals(key)) {
//                return entry.getValue();
//            }
//        }
//        return null;
//    }
//
//    @Override
//    public void put(K key, V value) {
//        int hash = Math.abs(key.hashCode()) % capacity;
//        Entry<K, V> e = getEntry(key);
//        if (e != null) {
//            e.setValue(value);
//        } else {
//            this.hashTable[hash].add(new Entry<>(key, value));
//            this.numberOfElements++;
//        }
//    }
//
//    @Override
//    public void remove(K key) {
//        int hash = Math.abs(key.hashCode()) % capacity;
//        Entry<K, V> e = null;
//        for (Entry<K, V> entry : hashTable[hash]) {
//            if (entry.getKey() == key) {
//                e = entry;
//            }
//        }
//        if (e != null) {
//            hashTable[hash].remove(e);
//            numberOfElements--;
//        }
//    }
//
//    @Override
//    public List<K> keyList() {
//        List<K> keyList = new ArrayList<>();
//        for (List<Entry<K, V>> bucket : hashTable) {
//            for (Entry<K, V> entry : bucket) {
//                keyList.add(entry.key);
//            }
//        }
//        return keyList;
//    }
//
//    @Override
//    public int size() {
//        return this.numberOfElements;
//    }
//
//    @Override
//    public boolean isEmpty() {
//        return (this.numberOfElements == 0);
//    }
//
//
//}