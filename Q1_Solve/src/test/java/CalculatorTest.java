import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

class CalculatorTest {

    //Que 1-7

    private Calculator calculator;

    @org.junit.jupiter.api.BeforeAll
    static void setUpBeforeAll() {
        System.out.println("Running setup before all tests...");
    }

    @org.junit.jupiter.api.AfterAll
    static void setUpAfterAll() {
        System.out.println("Running cleanup after all tests...");
    }

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        System.out.println("Setting up before each test...");
        calculator = new Calculator();
    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
        System.out.println("Cleaning up after each test...");
    }

    @org.junit.jupiter.api.Test
    @DisplayName("Addition works")
    void add() {

        assertNull(calculator.add(null, 8));
        assertNotNull(calculator.add(8, 8));
        assertEquals(16,calculator.add(8,8));
        assertNotEquals(17,calculator.add(8,8));
        assertTrue(calculator.add(8, 8) > 10);
        assertFalse(calculator.add(8, 8) < 10);
    }

    @org.junit.jupiter.api.Test
    @DisplayName("Division works")
    void divide() {

        assertNull(calculator.divide(null, 8));
        assertNotNull(calculator.divide(8, 8));
        assertEquals(1,calculator.divide(8,8));
        assertNotEquals(17,calculator.divide(8,8));
        assertTrue(calculator.divide(8, 8) >= 1);
        assertFalse(calculator.divide(8, 8) < 1);

        assertTimeout(Duration.ofMillis(1), () -> calculator.add(8,8) );

//        assertTimeout(Duration.ofMillis(1), () ->
//        {
//            Thread.sleep(2);
//            calculator.add(45,10);
//        });
    }

    @org.junit.jupiter.api.Test
    void getArray() {
        assertArrayEquals(new int []{1,2,3}, calculator.getArray());
        int[] firstCall = calculator.getArray();
        int[] secondCall = calculator.getArray();
        assertSame(firstCall, secondCall);
    }

    @org.junit.jupiter.api.Test
    void getString() {
        List<String> str1 = Arrays.asList("1","2","3");
        List<String> str2 = Arrays.asList("1","2","3");

        assertLinesMatch(str1,str2);
    }

    @org.junit.jupiter.api.Test
    @DisplayName("Error check")
    void getException() {
        assertThrows(Exception.class,() -> calculator.divide(50,0));
        assertDoesNotThrow(() -> calculator.divide(50,2));
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/vals.csv") // Skipping the header line

    void testadd(int a, int b){
        assertEquals(5,calculator.add(2,3));
        assertEquals(7,calculator.add(2,5));
        assertEquals(0,calculator.add(0,0));
    }


    @ParameterizedTest
    @CsvSource({
            "2, 3, 5",
            "2, 5, 7",
            "0, 0, 0"
    })
    void testAdd(int a, int b, int expected) {
        assertEquals(expected, calculator.add(a, b));
    }

    @ParameterizedTest
    @ValueSource(ints = {2, 0, -1})
    void testadd(int a) {
        int b = 3; // Fixed second value for testing
        int expected = a + b; // Calculate the expected result
        assertEquals(expected, calculator.add(a, b));
    }

    @RepeatedTest(5)
    void generateRandomNumber() {
        {
            assertTrue(Math.random() < 10, "Random number is less than 10");
        }
    }


}
