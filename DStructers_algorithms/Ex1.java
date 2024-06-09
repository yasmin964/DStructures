//package DStructers_algorithms;
//
//interface Queue<T> {
//    void push(T item);
//    T pool();
//    T peek();
//    int size();
//    boolean isEmpty();
//}
//class Node<T> {
//    T value;
//    node<T> next;
//    public Node(T value, node<T> next) {
//        this.value = value;
//        this.next = next;
//    }
//}
//class LLQueue<T> implements queue<T> {
//    node<T> head;
//    node<T> tail;
//    int size;
//    public LLQueue(){
//        this.head = null;
//        this.tail = null;
//        this.size = 0;
//    }
//
//    @Override
//    public void offer(T value) {
//
//    }
//
//    /*
//        adds an item to the end of the queue.
//         It creates a new node with the given item and updates the tail reference.
//         */
//    @Override
//    public void push(T item) {
//        node<T> newNode = new node<>(item, null); // Create a new node with the given item
//
//        if (isEmpty()) {
//            // If the queue is empty, the new node becomes both the head and the tail
//            head = newNode;
//            tail = newNode;
//        } else {
//            // If the queue is not empty,
//            // add the new node to the end of the queue and update the tail
//            tail.next = newNode;//add new node
//            tail = newNode;//update
//        }
//        size++; // Increase the size of the queue
//    }
//    /*
//    removes and returns the item from the front of the queue.
//     It updates the head reference and updates the tail reference if necessary.
//     */
//
//    @Override
//    public T pool() {//объединить
//        if (!isEmpty()) {
//            T item = head.value; // Get the value of the head node
//            head = head.next; // Move the head to the next node
//
//            if (head == null) {
//                // If the head becomes null (i.e., there are no more nodes), update the tail to null as well
//                tail = null;
//            }
//
//            size--; // Decrease the size of the queue
//            return item;
//        }
//        return null; // Return null if the queue is empty
//    }
///*
//returns the item from the front of the queue without removing it.
// It returns the value of the head node
// */
//    @Override
//    public T peek() {
//        return this.head.value;
//    }
//
//    @Override
//    public int size() {
//        return this.size;
//    }
//
//    @Override
//    public boolean isEmpty() {
//        return (this.size == 0);
//    }
//}
//
///*
//interface Stack<T> {
//
//    void push(T item);
//    T pop();
//    T peek();
//    int size();
//    boolean isEmpty();
//}
//class ArrayStack<T> implements Stack<T> {
//    final int INITIAL_SIZE = 123;
//    ArrayList<T> items;
//    int stackSize;
//    public ArrayStack(){
//        this.items = new ArrayList<>();
//        this.items.ensureCapacity(INITIAL_SIZE);
//        this.stackSize = 0;
//    }
//    @Override
//    public void push(T item) {
//        this.items.add(this.stackSize,item);
//        this.stackSize++;
//    }
//
//    @Override
//    public T pop() {
//        if (this.stackSize <= 0) {
//            throw new RuntimeException("empty stack");
//        }
//        this.stackSize--;
//        T item =  this.items.get(this.stackSize);
//        this.items.remove(this.stackSize);
//        return item;
//    }
//
//    @Override
//    public T peek() {
//        if (this.stackSize <= 0) {
//            throw new RuntimeException("empty stack");
//        }
//        T item =  this.items.get(this.stackSize-1);
//        this.items.remove(this.stackSize);
//        return item;
//    }
//
//    @Override
//    public int size() {
//        return stackSize;
//    }
//
//    @Override
//    public boolean isEmpty() {
//        if (stackSize <= 0) {
//            return true;
//        }
//        return false;
//    }
//}
///*
//
// */
//public class Ex1 {
//    public static void main(String[] args) {
//        queue<String> queue = new LLQueue<>();
//
//        queue.push("DSA");
//        queue.push("isn't");
//        queue.push("boring");
//        System.out.println(queue.size());
//        while (!queue.isEmpty()) {
//            System.out.println(queue.pool());
//        }
//
//    }
//}