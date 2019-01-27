import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Stream;

public class Collatz implements Sequence {
    private int initial;
    private int value;

    Collatz (int initial) {
        this.initial = initial;
        this.value = initial;
    }

    @Override
    public Integer get() {
        int res = value;
        value = (value%2 == 0 ? value/2 : 3*value + 1);
        return res;
    }

    public Stream<Integer> getStream() {
        return Stream.iterate(initial, x -> x%2 == 0 ? x/2 : 3*x + 1);
    }

    public long getValue() {
        AtomicLong res = new AtomicLong(0);
        Stream.iterate(initial, x -> res.incrementAndGet() > 0 && x%2 == 0 ? x/2 : 3*x + 1)
                .peek(x -> System.out.print(x.toString() + " ")).anyMatch(x -> x == 1);
        System.out.println();
        return res.get();
    }

}
