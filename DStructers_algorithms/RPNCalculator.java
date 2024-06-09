package DStructers_algorithms;

import java.util.Stack;

public class RPNCalculator {

    // Метод для вычисления значения выражения в обратной польской записи
    public static int evaluateRPN(String expression) {
        // Разделение входной строки на токены (числа и операторы)
        String[] tokens = expression.split(" ");

        // Создание стека для хранения промежуточных результатов
        Stack<Integer> stack = new Stack<>();

        // Итерация по всем токенам выражения
        for (String token : tokens) {
            // Проверка, является ли токен числом
            if (isNumeric(token)) {
                // Если токен - число, помещаем его в стек
                stack.push(Integer.parseInt(token));//все числа в стэке
            } else {
                // Если токен - оператор, извлекаем два последних числа из стека
                int operand2 = stack.pop();
                int operand1 = stack.pop();

                // Выполнение операции в соответствии с оператором
                switch (token) {
                    case "+":
                        stack.push(operand1 + operand2);
                        break;
                    case "-":
                        stack.push(operand1 - operand2);
                        break;
                    case "*":
                        stack.push(operand1 * operand2);
                        break;
                    case "/":
                        stack.push(operand1 / operand2);
                        break;
                    default:
                        // Если оператор неизвестен, генерируем исключение
                        throw new IllegalArgumentException("Недопустимый оператор: " + token);
                }
            }
        }

        // Результат вычисления - единственное число, оставшееся в стеке
        return stack.pop();
    }

    // Вспомогательный метод для проверки, является ли строка числом
    private static boolean isNumeric(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            // Если не удалось преобразовать строку в число, возвращаем false
            return false;
        }
    }

    // Точка входа в программу
    public static void main(String[] args) {
        // Входное выражение в обратной польской записи
        String expression = "3 4 + 5 *";

        // Вычисление результата и вывод на экран
        int result = evaluateRPN(expression);
        System.out.println("Результат выражения \"" + expression + "\" равен: " + result);
    }
}
