package _03_array_and_method.practice;

public class P5_FindMinValue {
    public static void main(String[] args) {
        int []arr = {4, 12, 7, 8, 1, 6, 9};
        System.out.println("The smallest element in the array is: " + minValue(arr));
    }
    public static int minValue(int[] array){
        int res= array[0];
        for (int i = 1; i < array.length; i++) {
            if(res>array[i]){
                res= array[i];
            }
        }
        return res;
    }
}
