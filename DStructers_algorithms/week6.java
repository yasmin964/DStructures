package DStructers_algorithms;

import java.util.Scanner;

public class week6 {

    static class Pair<T, U, V> {
        T first;
        U second;
        V index; // Store the original index

        Pair(T first, U second, V index) {
            this.first = first;
            this.second = second;
            this.index = index;
        }

        T getFirst() {
            return first;
        }

        U getSecond() {
            return second;
        }

        V getIndex() {
            return index;
        }

        T getValue(int column) {
            return column == 0 ? first : (T) second;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        Pair<Integer, Integer, Integer>[] items = new Pair[num];
        for (int i = 0; i < num; i++) {
            int currentBid = sc.nextInt();
            int maximalBid = sc.nextInt();
            items[i] = new Pair<>(currentBid, maximalBid, i + 1); // Store the original index
        }
        int[] sortedIndices = radixsort(items, num);
        for (int i = num - 1; i >= 0; i--) {
            System.out.print(sortedIndices[i] + " ");
        }
    }

    static <T extends Comparable<T>> int[] radixsort(Pair<T, T, Integer>[] items, int n) {
        // Bucket sort for the first column (current bid)
        bucketSort(items, n, 0);

        // Apply bucket sort to the second column (max bid) for items with the same current bid
        for (int i = 1; i < n; i++) {
            if (items[i].getFirst().equals(items[i - 1].getFirst())) {
                int start = i - 1;
                while (i < n && items[i].getFirst().equals(items[i - 1].getFirst())) {
                    i++;
                }
                bucketSort(items, i - start, 1, start, i - 1);
            }
        }

        // Create the array of sorted indices
        int[] indices = new int[n];
        for (int i = 0; i < n; i++) {
            indices[i] = items[i].getIndex();
        }
        return indices;
    }

    static <T extends Comparable<T>> void bucketSort(Pair<T, T, Integer>[] items, int n, int column) {
        bucketSort(items, n, column, 0, n - 1);
    }

    static <T extends Comparable<T>> void bucketSort(Pair<T, T, Integer>[] items, int n, int column, int start, int end) {
        Pair<T, T, Integer>[] output = new Pair[n];
        int[] count = new int[n];

        T minValue = items[start].getValue(column);
        T maxValue = items[start].getValue(column);

        for (int i = start + 1; i <= end; i++) {
            T value = items[i].getValue(column);
            if (value.compareTo(minValue) < 0) {
                minValue = value;
            } else if (value.compareTo(maxValue) > 0) {
                maxValue = value;
            }
        }

        double range = (double) (maxValue.compareTo(minValue) == 0 ? 1 : maxValue.compareTo(minValue) + 1);

        for (int i = start; i <= end; i++) {
            int index = (int) ((items[i].getValue(column).compareTo(minValue) / range) * (n - 1));
            count[index]++;
        }

        for (int i = 1; i < n; i++) {
            count[i] += count[i - 1];
        }

        for (int i = end; i >= start; i--) {
            int index = (int) ((items[i].getValue(column).compareTo(minValue) / range) * (n - 1));
            output[count[index] - 1] = items[i];
            count[index]--;
        }

        System.arraycopy(output, 0, items, start, n);
    }
}
