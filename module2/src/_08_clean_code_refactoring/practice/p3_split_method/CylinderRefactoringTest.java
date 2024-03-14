package _08_clean_code_refactoring.practice.p3_split_method;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CylinderRefactoringTest {
    @Test
    public void getVolume() {
        double result = CylinderRefactoring.getVolume(10, 5);
        double expected = 942.4777960769379;
        assertEquals(expected, result);
    }
}
