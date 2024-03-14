package _04_class_and_object.exercise;

import java.util.Arrays;
import java.util.Date;

import static java.lang.StrictMath.floor;
import static java.lang.StrictMath.random;

public class E2_StopWatch {
  private Date startTime;
  private Date endTime;

  public E2_StopWatch() {
    startTime = new Date();
  }

  public void start() {
    startTime = new Date();
  }

  public void stop() {
    endTime = new Date();
  }

  public long getElapsedTime() {
    return endTime.getTime() - startTime.getTime();
  }

  public static void main(String[] args) {
    double[] arr = new double[10000];
    int length = arr.length;
    for (int i = 0; i < length; i++) {
      arr[i] = floor(random() * 10000);
    }

    System.out.println("----- Array before sort -----");
    System.out.println(Arrays.toString(arr));
    E2_StopWatch sw = new E2_StopWatch();
//    Arrays.sort(arr);
    selectionSort(arr);
    sw.stop();
    System.out.println("----- Array after sort -----");
    System.out.println(Arrays.toString(arr));
    System.out.printf("Elapsed Time: %d ms.", sw.getElapsedTime());
  }

  private static void selectionSort(double[] arr) {
    int length = arr.length;
    for (int i = 0; i < length; i++) {
      int min_pos = i;
      for (int j = i; j < length; j++) {
        if (arr[min_pos] > arr[j]) {
          min_pos = j;
        }
      }

      if (min_pos != i) {
        double tmp = arr[min_pos];
        arr[min_pos] = arr[i];
        arr[i] = tmp;
      }
    }
  }
}
