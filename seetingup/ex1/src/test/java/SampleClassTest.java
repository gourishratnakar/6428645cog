import org.junit.Test;
import static org.junit.Assert.*;

public class SampleClassTest {

    @Test
    public void testAdd() {
        SampleClass sample = new SampleClass();
        assertEquals(5, sample.add(2, 3));
    }
}
