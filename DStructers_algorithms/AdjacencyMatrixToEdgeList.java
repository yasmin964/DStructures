package DStructers_algorithms;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AdjacencyMatrixToEdgeList {

    // Метод для преобразования матрицы смежности в список рёбер
    public static List<Edge> adjacencyMatrixToEdgeList(int[][] graph) {
        List<Edge> edgeList = new ArrayList<>();
        int n = graph.length;

        for (int i = 0; i < n; i++) {
            //избежать повторного рассмотрения одной и той же пары вершин.
            for (int j = i + 1; j < n; j++) {//что исключает рассмотрение пары вершин (i, j) и (j, i) при i != j.
                if (graph[i][j] == 1) {
                    edgeList.add(new Edge(i + 1, j + 1)); // Вершины нумеруются с 1
                }
            }
        }

        return edgeList;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Чтение количества вершин
        int n = scanner.nextInt();

        // Чтение матрицы смежности
        int[][] adjacencyMatrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                adjacencyMatrix[i][j] = scanner.nextInt();
            }
        }

        // Преобразование и вывод списка рёбер
        List<Edge> edgeList = adjacencyMatrixToEdgeList(adjacencyMatrix);
        for (Edge edge : edgeList) {
            System.out.println(edge.u + " " + edge.v);
        }
    }

    // Простой класс для представления ребра
    static class Edge {
        int u, v;//u - это поле (или переменная) объекта, а не метод.

        public Edge(int u, int v) {
            this.u = u;
            this.v = v;
        }
    }
}
