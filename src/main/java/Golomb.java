import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Golomb implements Sequence {
    int current = 1;
    List<Integer> seq = new ArrayList<>();
    {
        seq.add(1);
    }

    private void next() {
        seq.add(1 + seq.get(current - seq.get(seq.get(current - 1) - 1)));
        current++;
    }

    @Override
    public Integer get() {
        int res = seq.get(current - 1);
        next();
        return res;
    }

    @Override
    public Stream<Integer> getStream() {
        return Stream.generate(this);
    }
}
