import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class KolakoskiFinite implements Sequence {
    int[] values;
    int currentValue;
    int currentElement;
    List<Integer> seq = new ArrayList<>();;

    KolakoskiFinite(int[] values) {
        this.values = Arrays.copyOf(values, values.length);
        currentValue = 0;
        currentElement = 0;
    }

    private void generateFrom(int index) {
        if (index == seq.size()) {
            for (int i = 0; i < values[currentValue]; i++) {
                seq.add(values[currentValue]);
            }
        }
        else {
            for (int i = 0; i < seq.get(index); i++) {
                seq.add(values[currentValue]);
            }
        }
        currentValue = (currentValue + 1)%values.length;
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
