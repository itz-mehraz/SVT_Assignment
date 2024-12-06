import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class GradeCalculatorTest {

    //Que 5

    @DisplayName("Grading system")

    @ParameterizedTest
    @CsvSource({
            "95, A",
            "85, B",
            "75, C",
            "65, D",
            "55, F"
    })
    void testGetGrade(int score, String expectedGrade) {
        assertEquals(expectedGrade, GradeCalculator.getGrade(score));
    }

    @ParameterizedTest
    @CsvSource({
            "-1",
            "101"
    })
    void testInvalidScores(int invalidScore) {
        assertThrows(IllegalArgumentException.class, () -> GradeCalculator.getGrade(invalidScore));
    }
}
