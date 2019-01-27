import java.util.stream.Stream;

public class Catalan implements Sequence {
    private int current = 0;

    private int computeBinominal(int n, int k) {
        if (k == 0 || k == n) {
            return 1;
        }

        return computeBinominal(n - 1, k - 1) + computeBinominal(n - 1, k);
    }

    private int value() {
        return computeBinominal(2 * current, current) / (current + 1);
    }

    @Override
    public Integer get() {
        int res = value();
        current++;
        return res;
    }

    @Override
    public Stream<Integer> getStream() {
        return Stream.iterate(0, x -> x + 1).map(x -> computeBinominal(2 * x, x) / (x + 1));
    }
}
