package _02_loop_in_java.practice.p1_prime_number;

public class PrimeNumber2 {
    public static void main(String[] args) {
        System.out.println(checkPrimeNumber(2));
    }

    private static boolean checkPrimeNumber(int num) {
        if(num < 2){
            return false;
        }

        /*n/2 intance of n-1 because một số không bao giờ chia hết cho số lớn hơn một nửa của nó*/
        for (int i = 2; i < num/2; i++){
            if (num % i == 0){
                return false;
            }
        }

        return true;
    }
}
