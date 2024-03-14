package _03_array_and_method.exercise.e1_remove_element;

import java.util.Scanner;

public class RemoveElement2 {
    public static void main(String[] args) {
        int[] a = {1,2,3,4,5,6,7};

        System.out.print("Input value to remove: ");
        Scanner scanner= new Scanner(System.in);
        int val= scanner.nextInt();
        int[] tmp= remove(a,val);

        for (int i = 0; i < tmp.length; i++) {
            System.out.println(tmp[i]);
        }
    }

    private static int[] remove(int[] arr, int val){
        int length= arr.length;
        int index=-1;
        for (int i = 0; i < length; i++) {
            if(arr[i]==val){
                index= i;
                break;
            }
        }

        if(index>=0){
            return removeByIndex(arr, index);
        }

        return null;
    }

    private static int[] removeByIndex(int[] arr, int index){
        int length= arr.length;
        int[] tmp= new int[length-1];
        for (int i=0 ,j = 0; i < length ; i++) {
            if(i!=index){
                tmp[j++]= arr[i];
            }
        }

        return tmp;
    }
}
