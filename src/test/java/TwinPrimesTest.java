import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TwinPrimesTest {

    @Test
    public void test() {
        TwinPrimes twinPrimes = new TwinPrimes();
        Integer[] expected = {	3, 5, 7, 11, 13, 17, 19, 29, 31, 41, 43, 59, 61, 71, 73, 101, 103, 107, 109, 137, 139, 149, 151, 179, 181, 191, 193, 197, 199, 227};
        Object[] result = twinPrimes.getStream().limit(30).toArray();
        for (int i = 0; i < 30; i++) {
            assertEquals((Integer) result[i], expected[i]);
        }
    }
}