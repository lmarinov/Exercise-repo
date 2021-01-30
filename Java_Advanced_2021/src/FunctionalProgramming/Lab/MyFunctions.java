package FunctionalProgramming.Lab;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class MyFunctions {
    public static Predicate<String> startsWithUppercase =
            str -> str != null
                    && !str.isEmpty()
                    && Character.isUpperCase(str.charAt(0));

    public static Predicate<Integer> isEven =
            n -> n % 2 == 0;

    public static String formatList (List<Integer> list){
            return list.stream()
                    .map(String::valueOf)
                    .collect(Collectors.joining(", "));
    }
}
