package _02_loop_in_java.exercise;

public class E3_PrimeLessHundres {
    public static void main(String[] args) {
        int i=1;
        do{
            i++;

            boolean isPrime= true;
            for (int j = 2; j < i; j++) {
                if(i%j==0){
                    isPrime= false;
                    break;
                }
            }

            if (isPrime){
                System.out.println(i);
            }
        }while (i<100);
    }
}
