import java.util.function.Predicate;
import java.util.stream.Stream;

public class TwinPrimes {

    public Stream<Integer> getStream() {
        Predicate<Integer> prime = x -> Stream.iterate(2, y -> y + 1).limit((long) Math.sqrt(x)).noneMatch(y -> x%y == 0);
        Predicate<Integer> biggerBrotherPrime = x -> Stream.iterate(2, y -> y + 1).limit((long) Math.sqrt(x + 2)).noneMatch(y -> (x + 2)%y == 0);
        Predicate<Integer> smallerBrotherPrime = x -> x > 3 && Stream.iterate(2, y -> y + 1).limit((long) Math.sqrt(x - 2)).noneMatch(y -> (x - 2)%y == 0);
        Predicate<Integer> twinPrime = prime.and(biggerBrotherPrime.or(smallerBrotherPrime));
        return Stream.iterate(3, x -> x + 2).filter(twinPrime);
    }
}