package DStructers_algorithms;

public class BinarySearch {

    public static int binarySearch(int[] arr, int target) {//array && numb for search
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {//цикл
            int mid = left + (right - left) / 2;//mid

            if (arr[mid] == target) {//проверка на среднее число
                return mid;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int target = 7;
        int result = binarySearch(arr, target);

        if (result != -1) {
            System.out.println("The target element " + target + " is found at index: " + result);
        } else {
            System.out.println("The target element " + target + " is not present in the array.");
        }
    }
}

