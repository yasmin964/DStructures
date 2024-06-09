package DStructers_algorithms;

public class SelectionSort {
    public static void main(String[] args) {
        int[] array = {5, 2, 8, 1, 7};

        System.out.println("Unsorted Array:");
        printArray(array);

        selectionSort(array);

        System.out.println("\nSorted Array:");
        printArray(array);
    }

    public static void selectionSort(int[] arr) {
        int n = arr.length;
        for (int i = 0;i < n-1;i++) {
            int minIndex = i;

            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j]<arr[minIndex]){
                    minIndex = j;
                }
            }
            // Swap the found minimum element with the first element
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
    }

    public static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.println(num + " ");
        }
        System.out.println();
    }
}
