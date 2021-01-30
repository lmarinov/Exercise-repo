package FunctionalProgramming.Exercise;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ReverseAndExclude {
    static List<String> guests = null;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        guests = Arrays.stream(scanner.nextLine().split("\\s+"))
                .collect(Collectors.toList());

        Map<String, Predicate<String>> predicates = new HashMap<>();

        String line;

        while (!"Print".equals(line = scanner.nextLine())) {
            String[] tokens = line.split(";");
            String predicateName = tokens[1] + tokens[2];

           if (tokens[0].contains("Add")){
               Predicate<String> predicate = getPredicate(tokens);
               predicates.put(predicateName, predicate);
           }else{
               //remove
               predicates.remove(predicateName);
           }
        }

        guests.stream().filter(guest -> {
            boolean isValid = true;
            for (Predicate<String> predicate : predicates.values()) {
                if (predicate.test(guest)){
                    isValid = false;
                }
            }

            return isValid;
        }).forEach(e -> System.out.print(e + " "));
    }

    private static Predicate<String> getPredicate(String[] tokens) {
        Predicate<String> predicate;

        switch (tokens[1]) {
            case "Starts with":
                predicate = name -> name.startsWith(tokens[2]);
                break;
            case "Ends with":
                predicate = name -> name.endsWith(tokens[2]);
                break;
            case "Length":
                predicate = name -> name.length() == Integer.parseInt(tokens[2]);
                break;
            case "Contains":
                predicate = name -> name.contains(tokens[2]);
                break;
            default:
                throw new IllegalStateException("Unknown command: " + tokens[1]);
        }

        return predicate;
    }
}
