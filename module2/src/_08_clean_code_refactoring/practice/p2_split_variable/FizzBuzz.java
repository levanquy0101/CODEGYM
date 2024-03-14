package _08_clean_code_refactoring.practice.p2_split_variable;

/*FizzBuzz là bài toán lập trình về câu lệnh điều kiện mình nghĩ ai học code cũng phải từng trải qua.
Nhập các số nguyên vào làm input. Nếu là số chia hết cho 3, chúng ta sẽ có Fizz; chia hết cho 5 là Buzz và chia hết cho cả 3 lẫn 5 là FizzBuzz.
Các trường hợp còn lại sẽ trả lại đúng giá trị input.*/
public class FizzBuzz {
    public static String fizzBuzz(int number){
        if(number % 3 == 0 && number % 5 == 0)
            return "FizzBuzz";

        if(number % 3 == 0)
            return "Fizz";

        if(number % 5 == 0)
            return "Buzz";

        return number + "";
    }
}
