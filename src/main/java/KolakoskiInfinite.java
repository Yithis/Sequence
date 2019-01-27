import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class KolakoskiInfinite implements Sequence {
    Supplier<Integer> values;
    int currentElement;
    List<Integer> seq = new ArrayList<>();;

    KolakoskiInfinite(Supplier<Integer> sup) {
        this.values = sup;
        currentElement = 0;
    }

    private void generateFrom(int index) {
        int val = values.get();
        if (index == seq.size()) {
            for (int i = 0; i < val; i++) {
                seq.add(val);
            }
        }
        else {
            for (int i = 0; i < seq.get(index); i++) {
                seq.add(val);
            }
        }
    }

    @Override
    public Integer get() {
        generateFrom(currentElement);
        int res = seq.get(currentElement);
        currentElement++;
        return res;
    }

    @Override
    public Stream getStream() {
        return Stream.generate(this);
    }
}
