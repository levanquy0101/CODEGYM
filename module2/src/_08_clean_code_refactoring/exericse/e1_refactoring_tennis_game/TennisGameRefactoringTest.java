package _08_clean_code_refactoring.exericse.e1_refactoring_tennis_game;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TennisGameRefactoringTest {
    @Test
    public void getScore() {
        String result = TennisGameRefactoring.getScore("John", "David", 6, 5);
        assertEquals("Advantage John", result);
    }
}
