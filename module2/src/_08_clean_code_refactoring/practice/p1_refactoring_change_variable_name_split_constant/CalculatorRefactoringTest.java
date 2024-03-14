package _08_clean_code_refactoring.practice.p1_refactoring_change_variable_name_split_constant;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorRefactoringTest {

    @Test
    public void testCalculateAdd() {
        int a = 1;
        int b = 1;
        char o = '+';
        int expected = 2;

        int result = CalculatorRefactoring.calculate(a, b, o);
        assertEquals(expected, result);
    }
}
