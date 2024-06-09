//package DStructers_algorithms;
//
//import java.util.Arrays;
//import java.util.Scanner;
//public class Main {
//    public static void main(String[] args) {
//        queue<String> queue = new NodeQueue<>();
//        Stack<String> stack = new ArrayStack<>();
//        Scanner userInputScanner = new Scanner(System.in);
//        System.out.print("Enter an expression: ");
//        String inputData = userInputScanner.nextLine();
//        Scanner scanner = new Scanner(inputData).useDelimiter(" ");
//
//        while (scanner.hasNext()) {
//            String token = scanner.next();
//            if (isInteger(token)) {
//                queue.offer(token);//доб в конец число
//            } else {
//                if (token.equals(")") || token.equals("-") || token.equals("+") || token.equals("*") || token.equals("/")){
//                    while (!stack.isEmpty()){
//                        String newSimbol = stack.pop();
//                        if (!newSimbol.equals("(")){
//                            queue.offer(newSimbol);
//                        }
//                    }
//                    if (!token.equals(")")){
//                        stack.push(token);
//                    }
//                }
//                else if (token.equals("min") || token.equals("max")) {
//                    String newSimbol = stack.pop();
//                    int doubleLength = stack.size();
//                    int i = 0;
//                    while (stack.peek().equals("min") || stack.peek().equals("max") || stack.isEmpty()) {
//                        if (stack.peek().equals("+") || stack.peek().equals("-") || stack.peek().equals("*")
//                                || stack.peek().equals("/")){
//
//                        }
//                    }
//
//                }
//            }
//        }
//        while (!stack.isEmpty()){
//            String newSimbol = stack.pop();
//            if (!newSimbol.equals("(")){
//                queue.offer(newSimbol);
//            }
//        }
//
//        while (!queue.isEmpty()) {
//            System.out.print(queue.pool() + " ");
//        }
//        System.out.println("\n");
//        System.out.println("----------");
//        while (!stack.isEmpty()) {
//            System.out.println(stack.pop());
//        }
//
//        userInputScanner.close();
//        scanner.close();
//    }
//
//    // Helper method to check if a string represents an integer
//    private static boolean isInteger(String str) {
//        try {
//            Integer.parseInt(str);
//            return true;
//        } catch (NumberFormatException e) {
//            return false;
//        }
//    }
//}
//
//class myArrayList<T> {
//    private static final int DEFAULT_CAPACITY = 10;
//    private Object[] array;
//    private int size;
//
//    public myArrayList() {
//        this.array = new Object[DEFAULT_CAPACITY];
//        this.size = 0;
//    }
//
//    public void add(int index, T element) {
//        //ensureCapacity(int size);
//        if (index < 0 || index > size) {
//            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
//        }
//        for (int i = size; i > index; i--) {
//            array[i] = array[i - 1];
//        }
//        array[index] = element;
//        size++;
//    }
//
//    public T get(int index) {
//        if (index < 0 || index >= size) {
//            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
//        }
//        return (T) array[index];
//    }
//
//    public void remove(int index) {
//        if (index < 0 || index >= size) {
//            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
//        }
//
//        for (int i = index; i < size - 1; i++) {
//            array[i] = array[i + 1];
//        }
//        array[--size] = null;
//    }
//
//    public void ensureCapacity(int size) {
//        if (size == array.length) {
//            int newCapacity = array.length * 2;
//            array = Arrays.copyOf(array, newCapacity);
//        }
//    }
//
//    public int size() {
//        return size;
//    }
//}
//
//interface Stack<T> {
//    void push(T value);
//    T pop();
//    T peek();
//    int size();
//    boolean isEmpty();
//}
//
//class ArrayStack<T> extends myArrayList<T> implements Stack<T> {
//    int stackSize;
//    final int maxCap = 100;
//    myArrayList<T> items;
//
//    public ArrayStack(){
//        this.stackSize = 0;
//        this.items = new myArrayList<T>();
//        this.items.ensureCapacity(this.maxCap);
//    }
//
//    @Override
//    public void push(T value) {
//        this.items.add(this.stackSize, value);
//        this.stackSize++;
//        if (stackSize > maxCap) {
//            throw new RuntimeException("Overflow");
//        }
//    }
//
//    @Override
//    public T pop() {
//        if (this.stackSize == 0) {
//            throw new RuntimeException("Cannot pop from an empty stack");
//        }
//        this.stackSize--;
//        T item = this.items.get(this.stackSize);
//        this.items.remove(this.stackSize);
//        return item;
//    }
//
//    @Override
//    public T peek() {
//        return this.items.get(this.stackSize - 1);
//    }
//
////    @Override
////    public T peekByIndex() {
////        return this.items.get(this.stackSize - 1);
////    }
//
//    @Override
//    public int size() {
//        return this.stackSize;
//    }
//
//    @Override
//    public boolean isEmpty() {
//        return(this.stackSize == 0);
//    }
//}
//
//class node<T>{
//    T value;
//    node<T> next;
//
//    public node(T value, node<T> next){
//        this.value = value;
//        this.next = next;
//    }
//}
//
//interface queue<T>{
//    void offer(T value);
//
//    /*
//    adds an item to the end of the queue.
//     It creates a new node with the given item and updates the tail reference.
//     */
//    void push(T item);
//
//    T pool();
//    T peek();
//    int size();
//    boolean isEmpty();
//}
//
//class NodeQueue<T> implements queue<T> {
//    node<T> head;
//    node<T> tail;
//    int queueSize;
//
//    public NodeQueue() {
//        this.head = null;
//        this.tail = null;
//        this.queueSize = 0;
//    }
//
//    @Override
//    public void offer(T value) {
//        if (this.head == null) {
//            this.head = new node<>(value, null);
//            this.tail = this.head;
//        } else {
//            this.tail.next = new node<>(value, null);
//            this.tail = this.tail.next;
//        }
//        this.queueSize++;
//    }
//
//    @Override
//    public void push(T item) {
//
//    }
//
//    @Override
//    public T pool() {
//        T value = this.head.value;
//        this.head = this.head.next;
//        if (this.head == null) {
//            this.tail = null;
//        }
//        this.queueSize--;
//        return value;
//    }
//
//    @Override
//    public T peek() {
//        return this.head.value;
//    }
//
//    @Override
//    public int size() {
//        return this.queueSize;
//    }
//
//    @Override
//    public boolean isEmpty() {
//        return (this.queueSize == 0);
//    }
//}