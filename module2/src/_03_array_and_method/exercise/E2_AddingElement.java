package _03_array_and_method.exercise;

import java.util.Scanner;

public class E2_AddingElement {
    public static void main(String[] args) {
        Scanner scanner= new Scanner(System.in);

        int size=0;
        do{
            System.out.print(size==0? "Input size of array: ": "Input size less than 20: ");
            size= scanner.nextInt();
        }while (size>20);

        int[] arr= new int[size];

        for (int i = 0; i < size; i++) {
            System.out.printf("Input value of index %d: ", i);
            int input= scanner.nextInt();
            arr[i]= input;
        }

        for (int i = 0; i < size; i++) {
            System.out.println(arr[i]);
        }

        System.out.println("Input value need insert: ");
        int val= scanner.nextInt();
        System.out.println("Input index need insert: ");
        int index= scanner.nextInt();

        int[] res= add(arr, val, index);
        for (int i = 0; i < res.length; i++) {
            System.out.println(res[i]);
        }

    }

    private static int[] add(int[] arr, int val, int index){
        int length= arr.length;

        int[] tmp= new int[length+1];
        for (int i = 0; i < length; i++) {
            tmp[i]= arr[i];
        }

        for (int i = length; i > index; i--) {
            if(i!=index){
                tmp[i]= arr[i-1];
            }
        }
        tmp[index]= val;

        return tmp;
    }
}
