import java.util.function.Supplier;
import java.util.stream.Stream;

public interface Sequence extends Supplier<Integer> {
    public Integer get();
    public Stream<Integer> getStream();
}
