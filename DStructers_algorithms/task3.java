package DStructers_algorithms;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
От матрицы смежности к списку ребер, ориентированный вариант
 */
public class task3 {
    public static List<Edge> directionalGraphEdges(int [][] graph){
        List<Edge> list = new ArrayList<>();
        int n = graph.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (graph[i][j] == 1) {
                    list.add(new Edge(i + 1, j + 1));
                }
            }
        }
        return list;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [][] matrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix [i][j]= sc.nextInt();
            }
        }
        List<Edge> list = directionalGraphEdges(matrix);
        for (Edge edge:list){
            System.out.println(edge.u + " "+ edge.v);
        }
    }
    static class Edge {
        int u, v;

        public Edge(int u, int v) {
            this.u = u;
            this.v = v;
        }
    }

}
