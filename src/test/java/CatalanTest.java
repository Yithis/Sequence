import org.junit.jupiter.api.Test;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class CatalanTest {

    @Test
    public void test() {
        Catalan catalan = new Catalan();
        Integer[] expected = {1, 1, 2, 5, 14, 42, 132, 429, 1430, 4862, 16796, 58786, 208012, 742900, 2674440};
        Object[] result1 = catalan.getStream().limit(15).toArray();
        Object[] result2 = Stream.generate(catalan).limit(15).toArray();
        for (int i = 0; i < 15; i++) {
            assertEquals((Integer) result1[i], expected[i]);
            assertEquals((Integer) result2[i], expected[i]);
        }
    }
}