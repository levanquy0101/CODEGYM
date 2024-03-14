package _03_array_and_method.practice.p1_reserve_array;

import java.util.Arrays;

public class ReserveArray2 {

  public static void main(String[] args) {
    int[] array = new int[] {23, 9, 84, 16, 05, 22};
    System.out.println(Arrays.toString(array));
    System.out.println(Arrays.toString(reserveArray(array)));
  }

  private static int[] reserveArray(int[] array) {
    int length = array.length;

    for (int i = 0; i < length / 2; i++) {
/*      Swap Using Addition and Subtraction
      a = a + b;
      b = a - b; // actually (a + b) - (b), so now b is equal to a
      a = a - b; // (a + b) -(a), now a is equal to b*/

//      array[i] = array[i] + array[length - i - 1];
//      array[length - i - 1] = array[i] - array[length - i - 1];
//      array[i] = array[i] - array[length - i - 1];


/*      using XOR trick, best solution
      x = x ^ y;
      y = x ^ y; // now y = x
      x = x ^ y; // now x = y*/

      array[i] = array[i] ^ array[length - i - 1];
      array[length - i - 1] = array[i] ^ array[length - i - 1];
      array[i] = array[i] ^ array[length - i - 1];
    }

    return array;
  }
}
