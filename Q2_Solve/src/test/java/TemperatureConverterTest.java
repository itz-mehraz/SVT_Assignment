import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import static org.junit.jupiter.api.Assertions.*;

public class TemperatureConverterTest {

    //Que 2

    @ParameterizedTest
    @CsvFileSource(resources = "/vals.csv", numLinesToSkip = 1)
    void testCelsiusToFahrenheit(double celsius, double expectedFahrenheit) {

        assertEquals(expectedFahrenheit,
                TemperatureConverter.celsiusToFahrenheit(celsius),
                0.01,
                "Conversion from Celsius to Fahrenheit should match the expected value.");
    }

    @Test
    void testCelsiusToFahrenheit_ExceptionForAbsoluteZero() {

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> TemperatureConverter.celsiusToFahrenheit(-274),
                "Expected an exception for temperatures below absolute zero.");

        assertEquals("Temperature below absolute zero", exception.getMessage());
    }
}
