package DStructers_algorithms;

import java.util.*;

public class ParallelEdgesCheck {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Чтение количества вершин и рёбер
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        // Инициализация списка рёбер
        List<Edge> edges = new ArrayList<>();

        // Чтение рёбер и проверка наличия параллельных рёбер
        boolean hasParallelEdges = false;
        for (int i = 0; i < m; i++) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();

            //ОБРАТИ ВНИМАНИЕ
            Edge edge = new Edge(u, v);
            if (edges.contains(edge) || edges.contains(edge.reverse())) {
                hasParallelEdges = true;
                break;
            }

            edges.add(edge);
        }

        // Вывод результата
        if (hasParallelEdges) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }

    static class Edge {
        int u, v;

        public Edge(int u, int v) {
            this.u = Math.min(u, v);
            this.v = Math.max(u, v);
        }

        public Edge reverse() {
            return new Edge(v, u);
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            Edge edge = (Edge) obj;
            return u == edge.u && v == edge.v;
        }

        @Override
        public int hashCode() {
            return Objects.hash(u, v);
        }
    }
}
