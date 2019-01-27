import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LinearTest {

    @Test
    public void test() {
        int[] coef = {1, 1};
        int[] first = {1, 0};
        Linear fib = new Linear(first, coef);
        Integer[] expected = {0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610, 987, 1597, 2584, 4181,
                6765, 10946, 17711, 28657, 46368, 75025, 121393, 196418, 317811, 514229
        };

        Object[] result = fib.getStream().limit(30).toArray();

        for (int i = 0; i < 30; i++) {
            assertEquals((Integer) result[i], expected[i]);
        }

        fib = new Linear(first, coef, 20);
        Integer[] expected2 = {6765, 10946, 17711, 28657, 46368, 75025, 121393, 196418, 317811, 514229,
                832040, 1346269, 2178309, 3524578, 5702887, 9227465, 14930352, 24157817, 39088169, 63245986
        };
        Object[] result2 = fib.getStream().limit(20).toArray();
        for (int i = 0; i < 20; i++) {
            assertEquals((Integer) result2[i], expected2[i]);
        }
    }
}