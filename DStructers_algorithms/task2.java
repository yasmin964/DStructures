package DStructers_algorithms;

import java.util.Scanner;

public class task2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();//количество тунелей
        int m = sc.nextInt();//количество перекрестков
        // Инициализация массива для хранения количества светофоров на каждом перекрестке
        int[] trafficLights = new int[n];

        // Ввод данных о тоннелях
        for (int i = 0; i < m; i++) {
            int from = sc.nextInt();
            int to = sc.nextInt();

            // Установка светофоров на перекрестках
            trafficLights[from - 1]++;//на определенный индекс прибавл 1
            trafficLights[to - 1]++;//(1,2), (2,3), (3,4)
        }

        // Вывод результатов
        for (int i = 0; i < n; i++) {
            System.out.print(trafficLights[i] + " ");
        }
    }
}