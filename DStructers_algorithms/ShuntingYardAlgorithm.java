package DStructers_algorithms;//Yasmina Mamadalieva
import java.util.Arrays;
import java.util.Scanner;
import java.util.Iterator;
public class ShuntingYardAlgorithm {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String expression = sc.nextLine();
        int result = evaluateExpression(expression);
        System.out.println(result);

    }

    static int getPrecedence(String operator) {
        if (operator == null) {
            return 3;
        }
        if (operator.equals("*") || operator.equals("/")) {
            return 2;
        } else if (operator.equals("+") || operator.equals("-")) {
            return 1;
        } else {
            return 0; // Default precedence for other operators
        }
    }

    static boolean isOperator(String token) {
        return token.equals("+") || token.equals("-") ||
                token.equals("*") || token.equals("/") ||
                token.equals("min") || token.equals("max");
    }

    static boolean isFunction(String token) {
        return token.equals("min") || token.equals("max");
    }

    static boolean isLeftParenthesis(String token) {
        return token != null && token.equals("(");
    }

    static boolean isRightParenthesis(String token) {
        return token != null && token.equals(")");
    }

    static boolean isComma(String token) {
        return token != null && token.equals(",");
    }

    static MyArrayList<String> convertToPostfix(String expression) {
        MyArrayList<String> postfix = new MyArrayList<>();
        StackADT<String> operatorStack = new StackADT<>();
        String[] tokens = expression.split(" ");

        for (String token : tokens) {
            if (!isOperator(token) && !isLeftParenthesis(token) && !isRightParenthesis(token) && !isComma(token)) {
                // Current token is a number, append to the output
                postfix.add(token);
            } else if (isFunction(token)) {
                // Current token is a function, push to the operator stack
                operatorStack.push(token);
            } else if (isOperator(token)) {
                // Current token is an operator
                while (!operatorStack.isEmpty() && !isLeftParenthesis(operatorStack.peek()) &&
                        getPrecedence(operatorStack.peek()) >= getPrecedence(token)) {
                    // Pop operators with higher or equal precedence from the stack and append to the output
                    postfix.add(operatorStack.pop());
                }
                // Push the current operator to the stack
                operatorStack.push(token);
            } else if (isLeftParenthesis(token)) {
                // Current token is a left parenthesis, push to the stack
                operatorStack.push(token);
            } else if (isRightParenthesis(token)) {
                // Current token is a right parenthesis, pop operators from the stack and append to the output
                while (!operatorStack.isEmpty() && !isLeftParenthesis(operatorStack.peek())) {
                    postfix.add(operatorStack.pop());
                }
                // Pop the left parenthesis from the stack
                if (operatorStack.isEmpty()) {


                } else {
                    operatorStack.pop();
                }
                // If the top of the stack is a function, append it to the output
                if (!operatorStack.isEmpty() && isFunction(operatorStack.peek())) {
                    postfix.add(operatorStack.pop());
                }
            } else if (token.equals(",")) {
                // Current token is a comma, pop operators from the stack and append to the output until a left parenthesis is encountered
                while (!operatorStack.isEmpty() && !isLeftParenthesis(operatorStack.peek())) {
                    postfix.add(operatorStack.pop());
                }
            }
        }

        // Pop any remaining operators from the stack and append to the output
        while (!operatorStack.isEmpty()) {
            postfix.add(operatorStack.pop());
        }

        return postfix;
    }

    static class MyArrayList<T> implements Iterable<T>{
        private static final int DEFAULT_CAPACITY = 11;
        private Object[] array;
        private int size;

        public MyArrayList() {
            this.array = new Object[DEFAULT_CAPACITY];
            this.size = 0;
        }

        //тип возвращаемого значения должен быть void, так как она просто добавляет элемент в стек, а не возвращает его.
        public void add(T element) {
            ensureCapacity();
            array[size++] = element;
        }

        public void ensureCapacity() {
            if (size == array.length) {
                int newCapacity = array.length * 2;
                array = Arrays.copyOf(array, newCapacity);//копия с новыми значениями
            }
        }

        public T get(int index) {
//        if (index < 0  || index >= size) {
//            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
//        }
            return (T) array[index];
        }

        public T remove(int index) {
            if (index < 0 || index >= size) {
                throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
            }

            T removedElement = (T) array[index]; // сохраняем удаленный элемент
            for (int i = index; i < size - 1; i++) {
                array[i] = array[i + 1];
            }
            //Вместо удаления элемента и сдвига всех остальных элементов на его место, вы просто устанавливаете его значение как null.
            size--;

            return removedElement; // возвращаем удаленный элемент
        }

        public int size() {
            return size;
        }
        public Iterator<T> iterator() {
            return new Iterator<T>() {
                private int currentIndex = 0;

                @Override
                public boolean hasNext() {
                    return currentIndex < size;
                }

                @Override
                public T next() {
                    return get(currentIndex++);
                }
            };
        }
    }

    // Stack ADT implementation
    static class StackADT<T> {
        private MyArrayList<T> stack;

        public StackADT() {
            this.stack = new MyArrayList<T>();
        }

        public void push(T element) {
            this.stack.add(element);
        }

        //тип возвращаемого значения должен быть T, так как она возвращает удаленный элемент из стека.
        public T pop() {
            if (isEmpty()) {
                throw new IllegalStateException("Stack is empty. Cannot pop from an empty stack.");
            }
            T element = stack.remove(size() - 1);
            return element;
        }

        public T peek() {
            if (isEmpty()) {
                throw new IllegalStateException("Stack is empty.");
            }
            return this.stack.get(size() - 1);
        }

        public int size() {
            return this.stack.size();
        }

        public boolean isEmpty() {
            return this.stack.size() == 0;
        }
    }

    public static int evaluateExpression(String expression) {
        MyArrayList<String> postfix = convertToPostfix(expression);
        return evaluatePostfix(postfix);
    }

    public static boolean isNumeric(String token) {
        try {
            Integer.parseInt(token);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static int evaluatePostfix(MyArrayList<String> postfix) {
        StackADT<Integer> operandStack = new StackADT<>();

        for (String token : postfix) {
            if (isNumeric(token)) {
                operandStack.push(Integer.parseInt(token));
            } else if (isFunction(token)) {
                int arg2 = operandStack.pop();
                int arg1 = operandStack.pop();
                int result = evaluateFunction(token, arg1, arg2);
                operandStack.push(result);
            } else if (isOperator(token)) {
                int operand2 = operandStack.pop();
                int operand1 = operandStack.pop();
                int result = performOperation(token, operand1, operand2);
                operandStack.push(result);
            }
        }
        return operandStack.peek();
    }

    private static int evaluateFunction(String functionName, int arg1, int arg2) {
        if (functionName.equals("min")) {
            return Math.min(arg1, arg2);
        } else if (functionName.equals("max")) {
            return Math.max(arg1, arg2);
        }
        throw new IllegalArgumentException("Unknown function: " + functionName);
    }


    private static int performOperation(String operator, int operand1, int operand2) {
        switch (operator) {
            case "+":
                return operand1 + operand2;
            case "-":
                return operand1 - operand2;
            case "*":
                return operand1 * operand2;
            case "/":
                if (operand2 == 0) {
                    throw new ArithmeticException("Division by zero");
                }
                return operand1 / operand2;
            default:
                throw new IllegalArgumentException("Unknown operator: " + operator);
        }
    }
}

