import java.util.Random;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class SupplierFunction {

    private final Predicate<Integer> numberGreaterThanHundred = i -> i > 100;

    public void raisedToPowerGreaterThanHundred() {
        Stream.generate(SupplierFunction.getResult)
                .limit(100)
                .map(number -> (int) Math.pow(number, 3))
                .filter(numberGreaterThanHundred)
                .forEach(System.out::println);
    }

    private static final Supplier<Integer> getResult = () -> {
        Supplier<Integer> randomValue = () -> new Random().nextInt(10);
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return randomValue.get();
    };
}
