package DStructers_algorithms;
import java.util.*;
public class VertexDegreesBasedOnEdges {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Чтение количества вершин и рёбер
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        // Инициализация списка смежности
        List<List<Integer>> adjacencyList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjacencyList.add(new ArrayList<>());
        }

        // Чтение рёбер и построение списка смежности
        for (int i = 0; i < m; i++) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            // Добавление рёбер в список смежности (граф неориентированный)
            adjacencyList.get(u - 1).add(v);
            adjacencyList.get(v - 1).add(u);
        }

        // Вычисление и вывод степеней вершин
        for (int i = 0; i < n; i++) {
            int degree = adjacencyList.get(i).size();
            System.out.println(degree);
        }
    }
}