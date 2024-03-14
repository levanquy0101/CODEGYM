package _03_array_and_method.exercise;

import java.util.Arrays;

public class S1_ColumnTotalCalculate {
    public static void main(String[] args) {
        int[][] a = new int[5][5];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                a[i][j] = (int)Math.round(Math.random()*50)+1;
            }
        }

        int col = 2;
        int res=0;
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                if(j == col){
                    res+=a[i][j];
                }
            }
        }

        for (int[] e: a) {
            System.out.println(Arrays.toString(e));
        }

        System.out.println(res);
    }
}
