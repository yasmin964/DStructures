package DStructers_algorithms;

import java.util.Scanner;

public class VertexDegrees {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Чтение количества вершин
        int n = scanner.nextInt();

        // Инициализация матрицы смежности
        int[][] adjacencyMatrix = new int[n][n];

        // Чтение матрицы смежности
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                adjacencyMatrix[i][j] = scanner.nextInt();
            }
        }

        // Вычисление и вывод степеней вершин
        for (int i = 0; i < n; i++) {
            int degree = calculateVertexDegree(adjacencyMatrix, i);
            System.out.println(degree);
        }
    }

    public static int calculateVertexDegree(int[][] adjacencyMatrix, int vertex) {
        int degree = 0;
        for (int j = 0; j < adjacencyMatrix.length; j++) {
            degree += adjacencyMatrix[vertex][j];
        }
        return degree;
    }
}

