package _08_clean_code_refactoring.practice.p2_split_variable;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FizzBuzzRefactoringTest {
    @Test
    public void fizzBuzz() {
        String result = FizzBuzz.fizzBuzz(30);
        String expected = "FizzBuzz";
        assertEquals(expected, result);
    }
}
