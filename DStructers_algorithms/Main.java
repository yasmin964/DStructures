package DStructers_algorithms;

import java.util.*;

public class Main {
    static class DSU {
        int[] rankParent;
        int[] size;

        public DSU(int n) {
            rankParent = new int[n + 1];
            size = new int[n + 1];
            Arrays.fill(rankParent, -1);
            Arrays.fill(size, 1);
        }

        int find(int i) {
            if (rankParent[i] == -1) return i;
            return rankParent[i] = find(rankParent[i]);
        }

        boolean union(int a, int b) {
            int aParent = find(a);
            int bParent = find(b);
            if (aParent == bParent) return false;
            if (size[aParent] >= size[bParent]) {
                size[aParent] += size[bParent];
                rankParent[bParent] = aParent;
            } else {
                size[bParent] += size[aParent];
                rankParent[aParent] = bParent;
            }
            return true;
        }
    }

    static class Edge implements Comparable<Edge> {
        int u, v, weight;

        public Edge(int u, int v, int weight) {
            this.u = u;
            this.v = v;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge other) {
            return Integer.compare(this.weight, other.weight);
        }
    }

    public static List<List<Integer>> minimumSpanningForest(int N, List<Edge> edges) {
        Collections.sort(edges);
        DSU dsu = new DSU(N);
        List<List<Integer>> forest = new ArrayList<>();
        for (Edge edge : edges) {
            if (dsu.union(edge.u, edge.v)) {
                forest.add(Arrays.asList(edge.u, edge.v, edge.weight));
            }
        }
        return forest;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int M = scanner.nextInt();
        List<Edge> edges = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            int weight = scanner.nextInt();
            edges.add(new Edge(u, v, weight));
        }
        List<List<Integer>> forest = minimumSpanningForest(N, edges);
        System.out.println(forest.size()- 1);
        for (List<Integer> tree : forest) {
            System.out.println(tree.size() + " " + tree.get(0));
            for (int i = 0; i < tree.size(); i++) {
                if (i == 0) System.out.print(tree.get(i));
                else System.out.print(" " + tree.get(i) + " " + tree.get(++i));
            }
            System.out.println();
        }
    }
}
