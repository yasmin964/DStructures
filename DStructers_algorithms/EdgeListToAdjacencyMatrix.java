package DStructers_algorithms;

import java.util.Scanner;

public class EdgeListToAdjacencyMatrix {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Чтение количества вершин и рёбер
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        // Инициализация матрицы смежности
        int[][] adjacencyMatrix = new int[n][n];

        // Чтение рёбер и заполнение матрицы
        for (int i = 0; i < m; i++) {
            int u = scanner.nextInt() - 1; // Вершины нумеруются с 1, переводим в индекс
            int v = scanner.nextInt() - 1;

            adjacencyMatrix[u][v] = 1;//если для оринтированного, оставляем только одно направление
            adjacencyMatrix[v][u] = 1; // Для неориентированного графа
        }

        // Вывод матрицы смежности
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(adjacencyMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}

