package DStructers_algorithms;

import java.util.ArrayList;
import java.util.Scanner;

public class GraphReversal {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Чтение количества вершин
        int n = scanner.nextInt();
        scanner.nextLine(); // перейти на следующую строку

        // Инициализация списка смежности
        ArrayList<ArrayList<Integer>> adjacencyList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            ArrayList<Integer> neighbors = new ArrayList<>();
            String[] neighborsStr = scanner.nextLine().split(" ");
            for (String neighborStr : neighborsStr) {
                if (!neighborStr.isEmpty()) {
                    neighbors.add(Integer.parseInt(neighborStr));//Если строка не пустая, она преобразует строку в целое число
                }
            }
            adjacencyList.add(neighbors);
        }

        // Построение развернутого графа
        ArrayList<ArrayList<Integer>> reversedGraph = reverseGraph(adjacencyList, n);

        // Вывод развернутого графа
        System.out.println(n);
        for (ArrayList<Integer> neighbors : reversedGraph) {
            for (int neighbor : neighbors) {
                System.out.print(neighbor + " ");
            }
            System.out.println();
        }
    }

    public static ArrayList<ArrayList<Integer>> reverseGraph(ArrayList<ArrayList<Integer>> graph, int n) {
        ArrayList<ArrayList<Integer>> reversedGraph = new ArrayList<>();//для хранения перевернутого графика.
        for (int i = 0; i < n; i++) {
            reversedGraph.add(new ArrayList<>());//Инициализирует каждую вершину в перевернутом графе пустым списком.
        }
//Внешний цикл выполняет итерацию по каждой вершине в исходном графе.
//- Внутренний цикл выполняет итерацию по каждому соседу текущей вершины в исходном графе (`graph.get(i)`).
        for (int i = 0; i < n; i++) {
            for (int neighbor : graph.get(i)) {
                //добавляет перевернутое ребро к перевернутому графу
                reversedGraph.get(neighbor - 1).add(i + 1);
            }
        }

        return reversedGraph;
    }
}
