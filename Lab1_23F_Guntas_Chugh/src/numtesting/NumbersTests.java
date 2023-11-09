package numtesting;
import Primary.Numbers;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class NumbersTests {

    @Test
    public void testAddValue() {
        Numbers numbers = new Numbers(3);

        // Adding values to the Numbers object
        numbers.addValue(1.0f);
        numbers.addValue(2.0f);
        numbers.addValue(3.0f);

        // Checking if the values were added correctly
        assertEquals("1.0 2.0 3.0 ", numbers.toString());
    }

    @Test
    public void testCalcAverage() {
        Numbers numbers = new Numbers();

        // Adding values to the Numbers object
        numbers.addValue(1.0f);
        numbers.addValue(2.0f);
        numbers.addValue(3.0f);

        // Calculating the average and checking if it matches the expected value
        assertEquals(2.0f, numbers.calcAverage(), 0.01); // All values sum up to 6, so the average is 6/3 = 2
    }

    @Test
    public void testFindMinMax() {
        Numbers numbers = new Numbers();

        // Adding values to the Numbers object
        numbers.addValue(1.0f);
        numbers.addValue(2.0f);
        numbers.addValue(3.0f);

        // Checking if the findMinMax method returns the expected result
        assertEquals("Minimum Value: 1.00\nMaximum Value: 3.00\nMaxValue modulo MinValue: 0.00", numbers.findMinMax());
    }

    @Test
    public void testFindModulusOfMinMax() {
        Numbers numbers = new Numbers();

        // Adding values to the Numbers object
        numbers.addValue(4.0f);
        numbers.addValue(2.0f);
        numbers.addValue(1.0f);

        // Checking if the findModulusOfMinMax method returns the expected result
        assertEquals(0.0f, numbers.findModulusOfMinMax(), 0.01); // Max = 4.0, Min = 1.0, Modulus = 4.0 % 1.0 = 0.0
    }

    @Test
    public void testGetFactorialMax() {
        Numbers numbers = new Numbers();

        // Adding values to the Numbers object
        numbers.addValue(5.5f);
        numbers.addValue(4.0f);
        numbers.addValue(7.0f);

        // Checking if the getFactorialMax method returns the expected result
        assertEquals(5040, numbers.getFactorialMax()); // Max value is 7, so the factorial of 7 is 5040
    }
}
