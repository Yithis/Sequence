import org.junit.jupiter.api.Test;

import java.util.function.Supplier;

import static org.junit.jupiter.api.Assertions.*;

class GolombTest {

    @Test
    public void test() {
        Golomb golomb = new Golomb();
        Integer[] expected = {1, 2, 2, 3, 3, 4, 4, 4, 5, 5, 5, 6, 6, 6, 6, 7, 7, 7, 7, 8, 8, 8, 8, 9, 9, 9, 9, 9, 10, 10};
        Object[] result = golomb.getStream().limit(30).toArray();
        for (int i = 0; i < 30; i++) {
            assertEquals((Integer) result[i], expected[i]);
        }

        KolakoskiInfinite kolakoskiInfinite = new KolakoskiInfinite(
                new Supplier<Integer>() {
                    private int current = 1;
                    @Override
                    public Integer get() {
                        int res = current;
                        current++;
                        return res;
                    }
                }
        );

        golomb = new Golomb();
        Object[] result1 = golomb.getStream().limit(100).toArray();
        Object[] result2 = kolakoskiInfinite.getStream().limit(100).toArray();
        for (int i = 0; i < 100; i++) {
            assertEquals(result1[i], result2[i]);
        }

    }
}