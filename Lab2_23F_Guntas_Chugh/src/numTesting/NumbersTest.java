package numTesting;
import Primary.Numbers;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class NumbersTest {

    @Test
    public void testAddValue() {
        Numbers numbers = new Numbers();
        numbers.addValue(10.5f);
        numbers.addValue(20.5f);
        assertEquals(2, numbers.getCount());
    }

    @Test
    public void testCalcAverage() {
        Numbers numbers = new Numbers();
        numbers.addValue(10.5f);
        numbers.addValue(20.5f);
        assertEquals(15.5f, numbers.calcAverage());
    }

    @Test
    public void testFindMinMax() {
        Numbers numbers = new Numbers();
        numbers.addValue(10.5f);
        numbers.addValue(20.5f);
        numbers.addValue(5.0f);
        assertEquals(0.50f, numbers.findModulusOfMinMax());
        assertEquals("Minimum Value: 5.00\nMaximum Value: 20.50\nMaxValue modulo MinValue: 0.50", numbers.findMinMax());
    }

    

    @Test
    public void testGetFactorialMax() {
        Numbers numbers = new Numbers();
        numbers.addValue(7.9f);
        numbers.addValue(2.5f);
        numbers.addValue(5.8f);
        assertEquals(5040, numbers.getFactorialMax());
    }

    @Test
    public void testToString() {
        Numbers numbers = new Numbers();
        numbers.addValue(10.5f);
        numbers.addValue(20.5f);
        numbers.addValue(5.0f);
        String expected = "10.5 \n20.5 \n5.0 \n";
        assertEquals(expected, numbers.toString());
    }

    @Test
    public void testGetValue() {
        Numbers numbers = new Numbers();
        numbers.addValue(10.5f);
        numbers.addValue(20.5f);
        numbers.addValue(5.0f);
        assertEquals(10.5f, numbers.getValue(0));
        assertEquals(20.5f, numbers.getValue(1));
        assertEquals(5.0f, numbers.getValue(2));
        assertEquals(-1, numbers.getValue(3)); // Invalid index
    }
    
    @Test
    public void testGetCount() {
        Numbers numbers = new Numbers();
        numbers.addValue(10.5f);
        numbers.addValue(20.5f);
        numbers.addValue(5.0f);
        int count = numbers.getCount();
        assertEquals(3, count, "Count should be 3 for an array with 3 values.");
    }
}
