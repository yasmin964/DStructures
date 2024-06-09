package DStructers_algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class ex2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();//count of vertices
        ArrayList[] graph = new ArrayList[n];// к кажд вершине все соединенные с ней дороги
        int m = sc.nextInt();//count of edges
        for (int i = 0; i < n + 1; i++) {
            graph[i] = new ArrayList<Integer>();
        }
        // Initialize ArrayLists for each vertex in the graph
        for (int i = 1; i <= m; i++) {
            int from, to;//дороги имеют направления
            from = sc.nextInt();
            to = sc.nextInt();
            graph[from].add(to);
            graph[to].add(from);
        }
        // Display the adjacency list
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < n + 1; j++) {
                System.out.println(graph [i].get(j) + " ");//print some els
            }
            System.out.println();//transition to the new line
        }
    }
}
