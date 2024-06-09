package DStructers_algorithms;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class week5_t2 {
    public static void sort(List<Integer> list) {
        int n = list.size();
        for (int i = 1; i < n; ++i) {
            int key = list.get(i);
            int j = i - 1;

            while (j >= 0 && list.get(j) > key) {
                list.set(j + 1, list.get(j));
                j = j - 1;
            }
            list.set(j + 1, key);
        }
    }
    public static void main(String[] args) {
        //input
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(); // Number of items
        int capacity = scanner.nextInt(); // Capacity

        //natural numbers wi
        List<Integer> weight = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            weight.add(scanner.nextInt());
        }

        List<Integer> value = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            value.add(scanner.nextInt());
        }

        int[][] dp = new int[n + 1][capacity + 1];//weight * capacity
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= capacity; j++) {
                if (weight.get(i - 1) <= j) {
                    dp[i][j] = Math.max(dp[i - 1][j], value.get(i - 1) + dp[i - 1][j - weight.get(i - 1)]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        /*
         пустой список itemsIncluded, который будет содержать индексы элементов, включенных в рюкзак.
         */
        List<Integer> itemsIncluded = new ArrayList<>();
        int i = n;
        int w = capacity;
        //Запускается цикл while, который продолжается, пока есть элементы i и доступное место w в рюкзаке больше 0.
        while (i > 0 && w > 0) {
            if (dp[i][w] != dp[i - 1][w]) {// это означает, что предмет i был добавлен в рюкзак.
                itemsIncluded.add(i);
                w -= weight.get(i - 1);//Вместимость рюкзака w уменьшается на вес добавленного предмета weight.get(i - 1).
            }
            i--;
        }
        sort(itemsIncluded);
        // Output
        System.out.println(itemsIncluded.size());
        for (int item : itemsIncluded) {
            System.out.print(item + " ");
        }

    }

}
