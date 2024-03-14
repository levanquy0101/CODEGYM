package _02_loop_in_java.practice.p1_prime_number;

import java.util.Scanner;

/*step 1: Nhập vào n
step 2: Kiểm tra nếu n < 2 thì kết luận n không phải là số nguyên tố
step 3: Lặp từ 2 tới (n-1), nếu trong khoảng này tồn tại số mà n chia hết thì kết luận n không phải là số nguyên tố, ngược lại n là số nguyên tố.*/
public class PrimeNumber1 {

  public static void main(String[] args) {
    while (true) {
      System.out.print("Enter the number:");
      Scanner scanner = new Scanner(System.in);
      int number = scanner.nextInt();

      System.out.print(number + " is ");
      System.out.println(isPrime(number) ? "prime" : "not prime");
    }
  }

  private static boolean isPrime(int num) {
    if (num < 2) {
      return false;
    }

    for (int i = 2; i < num / 2; i++) {
      if (num % i == 0) {
        return false;
      }
    }

    return true;
  }
}
