import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class CalculatorTest {

    Calculator calculator;

    @Before
    public void setUp() {
        calculator = new Calculator();
        System.out.println("Setup complete.");
    }

    @After
    public void tearDown() {
        System.out.println("Teardown complete.");
    }

    @Test
    public void testAddition() {
        int result = calculator.add(2, 3);  // Corrected: no 'a:' and 'b:'
        assertEquals(5, result);
    }

    @Test
    public void testMultiplication() {
        int result = calculator.multiply(4, 5);  // Corrected
        assertEquals(20, result);
    }
}

