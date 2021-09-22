import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        //exercise 1
        List<Integer> num = Arrays.asList(1, 2, 3, 4, 5);
        evenNumberFilterSquared(num);

        //exercise 2
        List<String> str = Arrays.asList("ASD", "Plus", "minus", "OK","Ok");
        System.out.println(moreThanTwoWithUpperCasePredicate(str));
        System.out.println(moreThanTwoWithUpperCaseStreamAPI(str));

        //exercise 3
        Map<MathOperations, BiFunction<Integer, Integer, Integer>> map = Operations.arephmeticActions();
        for (Map.Entry<MathOperations, BiFunction<Integer, Integer, Integer>> res : map.entrySet()) {
            System.out.println(res.getKey() + " " + res.getValue().apply(8, 9));
        }

        //exercise 4
        SupplierFunction supplierFunction = new SupplierFunction();
        supplierFunction.raisedToPowerGreaterThanHundred();


    }

    public static void evenNumberFilterSquared(List<Integer> num) {
        Function<Integer, Integer> squared = (input) -> (int) Math.pow(input, 2);

        List<Integer> result = num.stream()
            .filter(input -> input % 2 == 0)
            .map(squared)
            .collect(Collectors.toList());

        System.out.println(result);
    }



    public static boolean moreThanTwoWithUpperCasePredicate(List<String> list) {
        Predicate<String> tested = strings -> list.stream()
                .filter(string -> Character.isUpperCase(string.charAt(0)))
                .count() > 2;

        long count = list.stream()
                .filter(tested)
                .count();
        return count > 2;
    }

    public static boolean moreThanTwoWithUpperCaseStreamAPI(List<String> list) {
        long count = list.stream()
                .filter(s -> Character.isUpperCase(s.charAt(0)))
                .count();
        return count > 2;
    }

}
