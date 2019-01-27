import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class KolakoskiFiniteTest {
    @Test
    public void test() {
        int[] initialize = {2, 1, 3, 1};
        KolakoskiFinite kolakoskiFinite = new KolakoskiFinite(initialize);
        Integer[] expected = {2, 2, 1, 1, 3, 1, 2, 2, 2, 1, 3, 3, 1, 1, 2, 2, 1, 3, 3, 3, 1, 1, 1, 2, 1, 3, 3, 1, 1, 2};
        Object[] result = kolakoskiFinite.getStream().limit(30).toArray();
        for (int i = 0; i < 30; i++) {
            assertEquals((Integer) result[i], expected[i]);
        }
    }
}