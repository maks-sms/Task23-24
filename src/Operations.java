import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;

public class Operations {

    static BiFunction<Integer, Integer, Integer> plus = Integer::sum;
    static BiFunction<Integer, Integer, Integer> minus = (x, y) -> x - y;
    static BiFunction<Integer, Integer, Integer> divide = (x, y) -> x / y;
    static BiFunction<Integer, Integer, Integer> multiply = (x, y) -> x * y;
    static Map<MathOperations, BiFunction<Integer, Integer, Integer>> enamFunctionMap = new HashMap<>();

    public static Map<MathOperations, BiFunction<Integer, Integer, Integer>> arephmeticActions() {

        enamFunctionMap.put(MathOperations.PLUS, plus);
        enamFunctionMap.put(MathOperations.MINUS, minus);
        enamFunctionMap.put(MathOperations.DIVIDE, divide);
        enamFunctionMap.put(MathOperations.MULTIPLY, multiply);

        return enamFunctionMap;
    }
}
