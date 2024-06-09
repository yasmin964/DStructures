//package DStructers_algorithms;//Yasmina Mamadalieva
//
//import java.util.ArrayList;
//import java.util.Scanner;
//import java.util.List;
//import java.util.LinkedList;
//
//
//
//
//    public class FindNormalStudent {
//
//        public static void main(String[] args) {
//            Scanner scanner = new Scanner(System.in);
//
//            int N = scanner.nextInt();
//            if (N % 2 == 0) {
//                System.out.println("Number of students should be odd for finding the median.");
//                return;
//            }
//
//            scanner.nextLine(); // Consume the newline
//
//            Map<Integer, String> studentScores = new HashMap<>(10000);
//
//            for (int i = 0; i < N; i++) {
//                String[] details = scanner.nextLine().split(" ");
//                int score = 0;
//                try {
//                    score = Integer.parseInt(details[0]);
//                } catch (NumberFormatException e) {
//                    System.out.println("Invalid score for student: " + details[1]);
//                }
//                studentScores.put(score, details[1] + " " + details[2]);
//            }
//
//            String normalStudent = findNormalStudent(studentScores);
//            System.out.println(normalStudent);
//
//            scanner.close();
//        }
//
//        public static String findNormalStudent(Map<Integer, String> studentScores) {
//            if (studentScores == null || studentScores.isEmpty()) {
//                throw new IllegalArgumentException("Student scores map cannot be null or empty.");
//            }
//
//            // Find the middle index to get the median
//            int middleIndex = studentScores.size() / 2;
//            int middleScore = findKthSmallest(new ArrayList<>(studentScores.keyList()), 0, studentScores.size() - 1, middleIndex);
//
//            return studentScores.get(middleScore);
//        }
//
//        private static int findKthSmallest(List<Integer> scores, int left, int right, int k) {
//            if (left <= right) {
//                return scores.get(left);
//            }
//
//            // Divide the list into groups of size 5
//            int n = right - left + 1;
//            int numGroups = (n + 4) / 5;
//            List<Integer> medians = new ArrayList<>();
//
//            // Find the median of each group
//            for (int i = 0; i < numGroups; i++) {
//                int groupLow = left + i * 5;
//                int groupHigh = Math.min(left + i * 5 + 4, right);
//                medians.add(findMedian(scores, groupLow, groupHigh));
//            }
//
//            // Find the median of medians
//            int medOfMed = (numGroups == 1) ? medians.get(0) : findKthSmallest(medians, 0, numGroups - 1, numGroups / 2);
//
//            // Partition around the median of medians
//            int pivotIndex = pivot(scores, left, right);
//            pivotIndex = partition(scores, left, right, pivotIndex, k);
//            int pivotRank = pivotIndex - left + 1;
//
//            if (k == pivotIndex) {
//                return scores.get(k);
//            } else if (k < pivotIndex) {
//                return findKthSmallest(scores, left, pivotIndex - 1, k);
//            } else {
//                return findKthSmallest(scores, pivotIndex + 1, right, k);
//            }
//        }
//        private static int pivot(List<Integer> list, int left, int right) {
//            return left + (right - left) / 2;
//        }
//
////        public static int findMedian(List<Integer> list, int low, int high) {
////            List<Integer> sublist = new ArrayList<>(list.subList(low, high + 1));
////            sublist.sort(null);
////            return sublist.get(sublist.size() / 2);
////        }
//
//        private static int partition(List<Integer> scores, int left, int right, int pivotValue) {
//            int idx = scores.indexOf(pivotValue);
//            swap(scores, idx, right);
//
//            int storeIndex = left;
//            for (int i = left; i < right; i++) {
//                if (scores.get(i) < pivotValue) {
//                    swap(scores, i, storeIndex);
//                    storeIndex++;
//                }
//            }
//
//            swap(scores, storeIndex, right);
//
//            return storeIndex;
//        }
//
//        private static int partition(List<Integer> scores, int left, int right, int idx, int k) {
//            int pivotValue = scores.get(idx);
//            swap(scores, idx, right);
//
//            int storeIndex = left;
//            for (int i = left; i < right; i++) {
//                if (scores.get(i) < pivotValue) {
//                    swap(scores, i, storeIndex);
//                    storeIndex++;
//                }
//            }
//
//            swap(scores, storeIndex, right);
//            if (k < storeIndex) {
//                return storeIndex;
//            } else {
//                return k;
//            }
//        }
//
//        private static void swap(List<Integer> scores, int i, int j) {
//            int temp = scores.get(i);
//            scores.set(i, scores.get(j));
//            scores.set(j, temp);
//        }
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
//        List <K> keyList();
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
//            this.capacity = capacity; // Initialize the capacity
//            this.numberOfElements = 0;
//            this.hashTable = new List[capacity];
//            for (int i = 0; i < capacity; i++) {
//                this.hashTable[i] = new LinkedList<>();
//            }
//        }
//
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
//        public List<K> keyList() {
//            List<K> keyList = new ArrayList<>();
//            for (List<Entry<K, V>> bucket : hashTable) {
//                for (Entry<K, V> entry : bucket) {
//                    keyList.add(entry.key);
//                }
//            }
//            return keyList;
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
//
//    }
//}
