package DStructers_algorithms;

import java.util.ArrayList;
import java.util.Scanner;

public class task1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();//count of vertices
        int[][] matrix = new int[n][n];
        //считывание
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }
        //подсчет
        int ways = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == matrix[j][i]) {
                    ways += matrix[i][j] ;
                }
            }
        }
        System.out.println(ways/2);
    }
}