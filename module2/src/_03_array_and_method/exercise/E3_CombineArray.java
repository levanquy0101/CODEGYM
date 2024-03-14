package _03_array_and_method.exercise;

public class E3_CombineArray {
    public static void main(String[] args) {
        int[] arr1= {1,3,5,7,9};
        int[] arr2= {55,32,88,55};
        int length1= arr1.length;
        int length2= arr2.length;

        int[] res= new int[length1+ length2];

        for (int i = 0; i < length1; i++) {
            res[i]= arr1[i];
        }

        for (int i = 0; i < length2 ; i++) {
            res[length1+i]= arr2[i];
        }

        for (int i = 0; i < res.length; i++) {
            System.out.println(res[i]);
        }
    }
}
