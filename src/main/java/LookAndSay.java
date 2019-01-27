import java.util.stream.Stream;

public class LookAndSay {
    private String value;

    LookAndSay(int value) {
        this.value = String.valueOf(value);
    }

    private void next() {
        StringBuilder new_value = new StringBuilder();
        int count = 1;
        for (int i = 0; i < value.length(); i++) {
            if (i == value.length() - 1 || value.charAt(i) != value.charAt(i+1)) {
                new_value.append(count);
                new_value.append(value.charAt(i));
                count = 1;
            }
            else {
                count++;
            }
        }
        value = new_value.toString();
    }

    public String get() {
        String res = value;
        next();
        return res;
    }

    public Stream<String> getStream() {
        return Stream.iterate(value,
                x -> {
                    StringBuilder new_value = new StringBuilder();
                    int count = 1;
                    for (int i = 0; i < x.length(); i++) {
                        if (i == x.length() - 1 || x.charAt(i) != x.charAt(i + 1)) {
                            new_value.append(count);
                            new_value.append(x.charAt(i));
                            count = 1;
                        } else {
                            count++;
                        }
                    }
                    return new_value.toString();
                }
                );
    }
}
