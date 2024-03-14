package _03_array_and_method.exercise;

import java.util.Arrays;
import java.util.Scanner;

public class S2_DiagonalTotalCalculate {
    public static void main(String[] args) {
        int[][] arr1 = create2dArray();
        for (int[] arr : arr1) {
            System.out.println(Arrays.toString(arr));
        }
        System.out.println("The sum of diagonal1 of matrix is " + sumDiagonal(arr1));
        System.out.println("The sum of diagonal2 of matrix is " + sumDiagonal2(arr1));
    }

    public static int sumDiagonal(int[][] matrix) {
        int sum = 0;
        for (int i = 0; i < matrix.length; i++) {
            sum += matrix[i][i];
        }
        return sum;
    }

    public static int sumDiagonal2(int[][] matrix){
        int sum=0;

        for (int i = 0; i < matrix.length; i++) {
            sum+= matrix[i][matrix.length-1-i];
        }
        return sum;
    }

    public static int[][] create2dArray() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Input size of matrix: ");
        int size = Integer.parseInt(scanner.nextLine());
        int[][] arr2d = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                arr2d[i][j] = (int) Math.round(Math.random() * 100) + 1;
            }
        }
        return arr2d;
    }
}
