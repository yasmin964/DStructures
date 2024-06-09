package DStructers_algorithms;

public class GraphChecker {

    // Метод для проверки матрицы смежности на неориентированность
    public static boolean isUndirected(int[][] graph) {
        int n = graph.length;

        // Проверяем симметрию матрицы
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (graph[i][j] != graph[j][i]) {//не имеют такую же дорогу с другим порядком
                    return false;
                }
            }
        }

        return true;
    }

    // Метод для проверки матрицы смежности на простоту
    public static boolean isSimple(int[][] graph) {
        int n = graph.length;

        // Проверяем отсутствие петель и кратных рёбер
        for (int i = 0; i < n; i++) {
            if (graph[i][i] == 0) {
                return false; // Петли не допускаются
            }

            for (int j = 0; j < n; j++) {
                if (i != j && graph[i][j] > 1) {
                    return false; // Кратные рёбра не допускаются
                    // Кратные рёбра - это ситуация, когда между двумя вершинами существует более одного ребра. В условии graph[i][j] > 1 мы проверяем, есть ли в данной ячейке
                    //матрицы значение больше единицы, что указывает на наличие кратных рёбер.
                }
            }
        }

        return true;
    }
    //Количество рёбер в неориентированном графе можно посчитать, просуммировав все элементы матрицы смежности и поделив на 2,
    // так как каждое ребро будет учтено дважды (раз в каждом направлении).

    public static void main(String[] args) {
        // Пример использования
        int[][] adjacencyMatrix = {
                {0, 1, 0, 1},
                {1, 0, 1, 0},
                {0, 1, 0, 1},
                {1, 0, 1, 0}
        };

        if (isUndirected(adjacencyMatrix) && isSimple(adjacencyMatrix)) {
            System.out.println("Матрица представляет собой простой неориентированный граф.");
        } else {
            System.out.println("Матрица не является простым неориентированным графом.");
        }
    }
}

/*
public class GraphChecker {

    // Метод для проверки матрицы смежности на неориентированность и простоту
    // Возвращает -1, если граф не является простым и неориентированным, иначе возвращает количество рёбер
    public static int checkGraph(int[][] graph) {
        int n = graph.length;

        // Проверяем симметрию матрицы
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (graph[i][j] != graph[j][i]) {
                    return -1;
                }
            }
        }

        // Проверяем отсутствие петель и кратных рёбер
        for (int i = 0; i < n; i++) {
            if (graph[i][i] != 0) {
                return -1; // Петли не допускаются
            }

            for (int j = 0; j < n; j++) {
                if (i != j && graph[i][j] > 1) {
                    return -1; // Кратные рёбра не допускаются
                }
            }
        }

        // Подсчитываем количество рёбер
        int edgeCount = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                edgeCount += graph[i][j];
            }
        }

        return edgeCount;
    }

    public static void main(String[] args) {
        // Пример использования
        int[][] adjacencyMatrix = {
                {0, 1, 0, 1},
                {1, 0, 1, 0},
                {0, 1, 0, 1},
                {1, 0, 1, 0}
        };

        int edges = checkGraph(adjacencyMatrix);

        if (edges != -1) {
            System.out.println("Матрица представляет собой простой неориентированный граф.");
            System.out.println("Количество рёбер в графе: " + edges);
        } else {
            System.out.println("Матрица не является простым неориентированным графом.");
        }
    }
}

 */