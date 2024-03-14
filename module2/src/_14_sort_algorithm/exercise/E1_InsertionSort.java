package _14_sort_algorithm.exercise;

public class E1_InsertionSort {
    public static void main(String[] args) {
        int[] arr = {32, 1, 59, 18, 12};
        insertionSort(arr);
        display(arr);
    }

    private static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int tmp = arr[i];
            int pos = i - 1;

            while (pos >= 0 && arr[pos] > tmp) {
                arr[pos + 1] = arr[pos];
                pos--;
            }

            arr[pos + 1] = tmp;

            System.out.printf("Loop %d: ", i);
            display(arr);
            System.out.println();
        }
    }

    private static void display(int[] arr) {
        int length = arr.length;
        for (int i = 0; i < length; i++){
            System.out.printf("%d ", arr[i]);
        }
    }
}
