import junit.framework.TestCase;
import org.junit.jupiter.api.Test;

public class ColatzTest extends TestCase {

    @Test
    public void test() {
        Collatz collatz = new Collatz(27);
        long actual = collatz.getValue();
        assertEquals(111, actual);

        collatz = new Collatz(15);
        Integer[] expected = {15, 46, 23, 70, 35, 106, 53, 160, 80, 40, 20, 10, 5, 16, 8, 4, 2, 1};
        Object[] result = collatz.getStream().limit(18).toArray();
        for (int i = 0; i < 18; i++) {
            assertEquals((Integer) result[i], expected[i]);
        }
    }
}