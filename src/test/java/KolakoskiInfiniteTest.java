import org.junit.jupiter.api.Test;

import java.util.function.Supplier;

import static org.junit.jupiter.api.Assertions.*;

class KolakoskiInfiniteTest {

    @Test
    public void test() {
        KolakoskiInfinite kolakoskiInfinite = new KolakoskiInfinite(
                new Supplier<Integer>() {
                    private int current = 2;
                    private int index = 0;
                    @Override
                    public Integer get() {
                        int res;
                        if (index%2 == 0) {
                            res = 1;
                        }
                        else {
                            res = current;
                            current++;
                        }
                        index++;
                        return res;
                    }
                }
        );
        Integer[] expected = {1, 2, 2, 1, 1, 3, 1, 4, 4, 4, 1, 5, 5, 5, 5, 1, 1, 1, 1, 6, 6, 6, 6, 1, 7, 7, 7, 7, 7, 1};
        Object[] result = kolakoskiInfinite.getStream().limit(30).toArray();
        for (int i = 0; i < 30; i++) {
            assertEquals((Integer) result[i], expected[i]);
        }
    }
}